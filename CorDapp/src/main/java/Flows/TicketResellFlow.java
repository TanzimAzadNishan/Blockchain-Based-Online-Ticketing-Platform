package Flows;

import Contracts.TicketContract;
import States.TicketState;
import co.paralleluniverse.fibers.Suspendable;
import net.corda.core.contracts.Command;
import net.corda.core.contracts.ContractState;
import net.corda.core.contracts.StateAndRef;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.crypto.SecureHash;
import net.corda.core.flows.*;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import net.corda.core.node.services.Vault;
import net.corda.core.node.services.vault.QueryCriteria;
import net.corda.core.transactions.SignedTransaction;
import net.corda.core.transactions.TransactionBuilder;
import net.corda.core.utilities.ProgressTracker;
import org.jetbrains.annotations.NotNull;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static net.corda.core.contracts.ContractsDSL.requireThat;

public class TicketResellFlow {

    @InitiatingFlow
    @StartableByRPC
    public static class TicketResellFlowInitiator extends FlowLogic<SignedTransaction>{

        //private final UniqueIdentifier curUserLinearId;
        private final UniqueIdentifier newUserLinearId;
        private final UniqueIdentifier ticketLinearId;
        private final Party newOwner;

        public TicketResellFlowInitiator(UniqueIdentifier newUserLinearId, UniqueIdentifier ticketLinearId, Party newOwner) {
            this.newUserLinearId = newUserLinearId;
            this.ticketLinearId = ticketLinearId;
            this.newOwner = newOwner;
        }

        @Suspendable
        @Override
        public SignedTransaction call() throws FlowException {

            // 1. Retrieve the Ticket State from the vault using LinearStateQueryCriteria
            List<UUID> listOfLinearIds = new ArrayList<>();
            listOfLinearIds.add(ticketLinearId.getId());
            QueryCriteria queryCriteria =
                    new QueryCriteria.LinearStateQueryCriteria(null, listOfLinearIds);

            // 2. Get a reference to the inputState data that we are going to settle.
            Vault.Page results = getServiceHub().getVaultService().queryBy(
                    TicketState.class, queryCriteria
            );
            StateAndRef inputStateAndRefToReSell = (StateAndRef) results.getStates().get(0);
            TicketState inputStateToReSell = (TicketState) inputStateAndRefToReSell.getState().getData();


            // 1. Retrieve the UserState from the vault using LinearStateQueryCriteria
            /*List<UUID> listOfUserIds = new ArrayList<>();
            listOfUserIds.add(newUserLinearId.getId());
            QueryCriteria queryCriteriaUser =
                    new QueryCriteria.LinearStateQueryCriteria(null, listOfUserIds);

            // 2. Get a reference to the inputState data that we are going to settle.
            Vault.Page userResults = getServiceHub().getVaultService().queryBy(
                    UserState.class, queryCriteriaUser
            );
            StateAndRef userStateRef = (StateAndRef) userResults.getStates().get(0);
            UserState newUserState = (UserState) userStateRef.getState().getData();*/


            Party notary = getServiceHub().getNetworkMapCache().getNotaryIdentities().get(0);
            final TransactionBuilder builder = new TransactionBuilder(notary);

            List<PublicKey> requiredSigners = inputStateToReSell.getParticipants()
                    .stream().map(AbstractParty::getOwningKey)
                    .collect(Collectors.toList());
            requiredSigners.add(newOwner.getOwningKey());

            Command<TicketContract.Commands.Resell> command =
                    new Command<>(new TicketContract.Commands.Resell(), requiredSigners);

            TicketState outputState = inputStateToReSell.withNewOwner(newOwner, newUserLinearId);
            //outputState = outputState.withNewOwner(newUserState);

            builder.addCommand(command);
            builder.addInputState(inputStateAndRefToReSell);
            builder.addOutputState(outputState, TicketContract.ID);

            // Ensure that this flow is being executed by the current owner.
            if (!inputStateToReSell.getCurrentOwner().getOwningKey().equals(getOurIdentity().getOwningKey())) {
                throw new IllegalArgumentException("This flow must be run by the current owner.");
            }

            builder.verify(getServiceHub());

            final SignedTransaction partiallySignedTx = getServiceHub().signInitialTransaction(builder);
            // Collect the other party's signature using the SignTransactionFlow.
            List<Party> otherParties = outputState.getParticipants()
                    .stream().map(el -> (Party)el)
                    .collect(Collectors.toList());

            otherParties.remove(getOurIdentity());
            /*List<TicketState> ticketStates = new ArrayList<>();
            ticketStates.add(inputStateToReSell);
            ticketStates.add(outputState);*/

            /*List<FlowSession> sessions = new ArrayList<>();
            for(Party party: otherParties){
                FlowSession session = initiateFlow(party);
                //session.send(ticketStates);
                sessions.add(session);
            }*/

            List<FlowSession> sessions = otherParties
                    .stream().map(el -> initiateFlow(el))
                    .collect(Collectors.toList());

            SignedTransaction fullySignedTx = subFlow(new CollectSignaturesFlow(partiallySignedTx, sessions));

            //  Return the output of the FinalityFlow which sends the transaction to the notary for verification
            //  and the causes it to be persisted to the vault of appropriate nodes.
            return subFlow(new FinalityFlow(fullySignedTx, sessions));
        }
    }



    @InitiatedBy(TicketResellFlow.TicketResellFlowInitiator.class)
    public static class TicketResellFlowResponder extends FlowLogic<SignedTransaction>{

        private final FlowSession otherPartyFlow;
        private SecureHash txWeJustSignedId;

        public TicketResellFlowResponder(FlowSession otherPartyFlow) {
            this.otherPartyFlow = otherPartyFlow;
        }

        @Suspendable
        @Override
        public SignedTransaction call() throws FlowException {
            class SignTxFlow extends SignTransactionFlow{

                private SignTxFlow(FlowSession otherPartyFlow, ProgressTracker progressTracker) {
                    super(otherPartyFlow, progressTracker);
                }

                @Override
                @NotNull
                protected void checkTransaction(SignedTransaction stx) throws FlowException {
                    requireThat(req -> {
                        ContractState output = stx.getTx().getOutputs().get(0).getData();
                        req.using("This must be an Ticket Resell transaction", output instanceof TicketState);
                        return null;
                    });
                    // Once the transaction has verified, initialize txWeJustSignedID variable.
                    txWeJustSignedId = stx.getId();
                }
            }

            /*List<TicketState> ticketStates = otherPartyFlow.receive(List.class).unwrap(it -> {
                return it;
            });
            UserState prevUserState = ticketStates.get(0).getCurrentOwner();
            UserState newUserState = ticketStates.get(1).getCurrentOwner();
            UniqueIdentifier eventLinearId = ticketStates.get(0).getEventId();


            // 1. Retrieve the EventState from the vault using LinearStateQueryCriteria
            List<UUID> listOfEventIds = new ArrayList<>();
            listOfEventIds.add(eventLinearId.getId());
            QueryCriteria queryCriteriaEvent =
                    new QueryCriteria.LinearStateQueryCriteria(null, listOfEventIds);

            // 2. Get a reference to the inputState data that we are going to settle.
            Vault.Page eventResults = getServiceHub().getVaultService().queryBy(
                    EventState.class, queryCriteriaEvent
            );
            StateAndRef eventStateRef = (StateAndRef) eventResults.getStates().get(0);
            EventState eventState = (EventState) eventStateRef.getState().getData();


            // update balance and EventState
            prevUserState.increaseBalance(ticketStates.get(0).getPrice());
            newUserState.decreaseBalance(ticketStates.get(0).getPrice());
            eventState.replaceTicketStateOfAEvent(ticketStates.get(1));*/


            // Create a sign transaction flow
            SignTxFlow signTxFlow = new SignTxFlow(otherPartyFlow, SignTransactionFlow.Companion.tracker());

            // Run the sign transaction flow to sign the transaction
            subFlow(signTxFlow);

            // Run the ReceiveFinalityFlow to finalize the transaction and persist it to the vault.
            return subFlow(new ReceiveFinalityFlow(otherPartyFlow, txWeJustSignedId));
        }
    }
}

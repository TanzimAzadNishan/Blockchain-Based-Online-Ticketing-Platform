package Flows;

import Contracts.TicketContract;
import States.EventState;
import States.TicketState;
import States.UserState;
import States.VendorState;
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

import static java.util.Collections.singletonList;
import static net.corda.core.contracts.ContractsDSL.requireThat;

public class TicketSellFlow {

    @InitiatingFlow
    @StartableByRPC
    public static class TicketSellFlowInitiator extends FlowLogic<SignedTransaction> {

        private final UniqueIdentifier vendorLinearId;
        private final UniqueIdentifier eventLinearId;
        private final UniqueIdentifier userLinearId;
        private Party newOwner;
        private final UniqueIdentifier ticketLinearId;

        public TicketSellFlowInitiator(UniqueIdentifier vendorLinearId, UniqueIdentifier eventLinearId,
                                       UniqueIdentifier userLinearId, UniqueIdentifier linearId) {
            this.vendorLinearId = vendorLinearId;
            this.eventLinearId = eventLinearId;
            this.userLinearId = userLinearId;
            this.newOwner = null;
            this.ticketLinearId = linearId;
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
            StateAndRef inputStateAndRefToSell = (StateAndRef) results.getStates().get(0);
            TicketState inputStateToSell = (TicketState) inputStateAndRefToSell.getState().getData();


            // 1. Retrieve the UserState from the vault using LinearStateQueryCriteria
            List<UUID> listOfUserIds = new ArrayList<>();
            listOfUserIds.add(userLinearId.getId());
            QueryCriteria queryCriteriaUser =
                    new QueryCriteria.LinearStateQueryCriteria(null, listOfUserIds);

            // 2. Get a reference to the inputState data that we are going to settle.
            Vault.Page userResults = getServiceHub().getVaultService().queryBy(
                    UserState.class, queryCriteriaUser
            );
            StateAndRef userStateRef = (StateAndRef) userResults.getStates().get(0);
            UserState newUserState = (UserState) userStateRef.getState().getData();


            Party notary = getServiceHub().getNetworkMapCache().getNotaryIdentities().get(0);
            final TransactionBuilder builder = new TransactionBuilder(notary);
            this.newOwner = newUserState.getUser();

            List<PublicKey> requiredSigners = inputStateToSell.getParticipants()
                    .stream().map(AbstractParty::getOwningKey)
                    .collect(Collectors.toList());
            requiredSigners.add(newOwner.getOwningKey());

            Command<TicketContract.Commands.Sell> command =
                    new Command<>(new TicketContract.Commands.Sell(), requiredSigners);

            TicketState outputState = inputStateToSell;
            outputState = outputState.withNewOwner(newUserState);

            builder.addCommand(command);
            builder.addInputState(inputStateAndRefToSell);
            builder.addOutputState(outputState, TicketContract.ID);

            // Ensure that this flow is being executed by ticket issuer.
            if (!inputStateToSell.getTicketIssuer().getAgency().getOwningKey().equals(getOurIdentity().getOwningKey())) {
                throw new IllegalArgumentException("This flow must be run by the ticket issuer.");
            }

            builder.verify(getServiceHub());

            final SignedTransaction partiallySignedTx = getServiceHub().signInitialTransaction(builder);

            // Collect the other party's signature using the SignTransactionFlow.
            /*List<Party> otherParties = outputState.getParticipants()
                    .stream().map(el -> (Party)el)
                    .collect(Collectors.toList());

            otherParties.remove(getOurIdentity());

            List<FlowSession> sessions = otherParties
                    .stream().map(el -> initiateFlow(el))
                    .collect(Collectors.toList());*/

            FlowSession sessions = initiateFlow(newOwner);
            //List<UniqueIdentifier> requiredIds = new ArrayList<>();
            //requiredIds.add(vendorLinearId);
            //requiredIds.add(eventLinearId);
            //sessions.send(requiredIds);
            sessions.send(outputState);

            SignedTransaction fullySignedTx = subFlow(new CollectSignaturesFlow(partiallySignedTx, singletonList(sessions)));

            //  Return the output of the FinalityFlow which sends the transaction to the notary for verification
            //  and the causes it to be persisted to the vault of appropriate nodes.
            return subFlow(new FinalityFlow(fullySignedTx, singletonList(sessions)));
        }
    }


    @InitiatedBy(TicketSellFlow.TicketSellFlowInitiator.class)
    public static class TicketSellFlowResponder extends FlowLogic<SignedTransaction>{

        private final FlowSession otherPartyFlow;
        private SecureHash txWeJustSignedId;

        public TicketSellFlowResponder(FlowSession otherPartyFlow) {
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
                        req.using("This must be an Ticket Sell transaction", output instanceof TicketState);
                        return null;
                    });
                    // Once the transaction has verified, initialize txWeJustSignedID variable.
                    txWeJustSignedId = stx.getId();
                }
            }

            TicketState ticketState = otherPartyFlow.receive(TicketState.class).unwrap(it -> {
                return it;
            });
            UniqueIdentifier eventLinearId = ticketState.getEventId();
            VendorState vendorState = ticketState.getTicketIssuer();
            UserState userState = ticketState.getCurrentOwner();


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

            // update event states and balance
            eventState.markTicketAsSold(ticketState);
            vendorState.increaseBalance(ticketState.getPrice());
            userState.decreaseBalance(ticketState.getPrice());


            // Create a sign transaction flow
            SignTxFlow signTxFlow = new SignTxFlow(otherPartyFlow, SignTransactionFlow.Companion.tracker());

            // Run the sign transaction flow to sign the transaction
            subFlow(signTxFlow);

            // Run the ReceiveFinalityFlow to finalize the transaction and persist it to the vault.
            return subFlow(new ReceiveFinalityFlow(otherPartyFlow, txWeJustSignedId));
        }
    }
}

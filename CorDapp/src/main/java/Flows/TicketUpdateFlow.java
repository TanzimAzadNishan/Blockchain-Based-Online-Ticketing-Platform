package Flows;

import Contracts.TicketContract;
import States.TicketState;
import co.paralleluniverse.fibers.Suspendable;
import net.corda.core.contracts.Command;
import net.corda.core.contracts.StateAndRef;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.flows.*;
import net.corda.core.identity.Party;
import net.corda.core.node.services.Vault;
import net.corda.core.node.services.vault.QueryCriteria;
import net.corda.core.transactions.SignedTransaction;
import net.corda.core.transactions.TransactionBuilder;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class TicketUpdateFlow {

    @InitiatingFlow
    @StartableByRPC
    public static class TicketUpdateFlowInitiator extends FlowLogic<SignedTransaction>{

        private final String eventDate;
        private final UniqueIdentifier ticketLinearId;

        public TicketUpdateFlowInitiator(String eventDate, UniqueIdentifier ticketLinearId) {
            this.eventDate = eventDate;
            this.ticketLinearId = ticketLinearId;
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
            StateAndRef inputStateAndRefToUpdate = (StateAndRef) results.getStates().get(0);
            TicketState inputStateToUpdate = (TicketState) inputStateAndRefToUpdate.getState().getData();

            Party notary = getServiceHub().getNetworkMapCache().getNotaryIdentities().get(0);

            final TransactionBuilder builder = new TransactionBuilder(notary);

            List<PublicKey> requiredSigners = new ArrayList<>();
            requiredSigners.add(getOurIdentity().getOwningKey());

            Command<TicketContract.Commands.Update> command =
                    new Command<>(new TicketContract.Commands.Update(), requiredSigners);

            TicketState outputState = inputStateToUpdate.withNewEventDate(eventDate);

            builder.addCommand(command);
            builder.addInputState(inputStateAndRefToUpdate);
            builder.addOutputState(outputState, TicketContract.ID);

            // Ensure that this flow is being executed by ticket issuer.
            if (!inputStateToUpdate.getTicketIssuer().getOwningKey().equals(getOurIdentity().getOwningKey())) {
                throw new IllegalArgumentException("This flow must be run by the ticket issuer.");
            }

            builder.verify(getServiceHub());
            final SignedTransaction partiallySignedTx = getServiceHub().signInitialTransaction(builder);
            
            // Collect the other party's signature using the SignTransactionFlow.
            List<Party> otherParties = outputState.getParticipants()
                    .stream().map(el -> (Party)el)
                    .collect(Collectors.toList());

            otherParties.remove(getOurIdentity());

            List<FlowSession> sessions = otherParties
                    .stream().map(el -> initiateFlow(el))
                    .collect(Collectors.toList());

            SignedTransaction fullySignedTx = subFlow(new CollectSignaturesFlow(partiallySignedTx, sessions));

            //  Return the output of the FinalityFlow which sends the transaction to the notary for verification
            //  and the causes it to be persisted to the vault of appropriate nodes.
            return subFlow(new FinalityFlow(fullySignedTx, sessions));
        }
    }
}

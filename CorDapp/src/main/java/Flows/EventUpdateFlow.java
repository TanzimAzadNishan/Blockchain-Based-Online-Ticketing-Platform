package Flows;

import Contracts.EventContract;
import Contracts.TicketContract;
import States.EventState;
import States.TicketState;
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

public class EventUpdateFlow {

    @InitiatingFlow
    @StartableByRPC
    public static class EventUpdateFlowInitiator extends FlowLogic<SignedTransaction>{

        private final String eventDate;
        private final UniqueIdentifier eventLinearId;

        public EventUpdateFlowInitiator(String eventDate, UniqueIdentifier eventLinearId) {
            this.eventDate = eventDate;
            this.eventLinearId = eventLinearId;
        }

        @Override
        public SignedTransaction call() throws FlowException {

            // 1. Retrieve the Event State from the vault using LinearStateQueryCriteria
            List<UUID> listOfLinearIds = new ArrayList<>();
            listOfLinearIds.add(eventLinearId.getId());
            QueryCriteria queryCriteria =
                    new QueryCriteria.LinearStateQueryCriteria(null, listOfLinearIds);

            // 2. Get a reference to the inputState data that we are going to settle.
            Vault.Page results = getServiceHub().getVaultService().queryBy(
                    EventState.class, queryCriteria
            );
            StateAndRef inputStateAndRefToUpdate = (StateAndRef) results.getStates().get(0);
            EventState inputStateToUpdate = (EventState) inputStateAndRefToUpdate.getState().getData();

            Party notary = getServiceHub().getNetworkMapCache().getNotaryIdentities().get(0);

            final TransactionBuilder builder = new TransactionBuilder(notary);
            List<PublicKey> requiredSigners = new ArrayList<>();
            requiredSigners.add(getOurIdentity().getOwningKey());

            Command<EventContract.Commands.Update> command =
                    new Command<>(new EventContract.Commands.Update(), requiredSigners);


            EventState outputState = inputStateToUpdate.withNewEventDate(eventDate);

            builder.addCommand(command);
            builder.addInputState(inputStateAndRefToUpdate);
            builder.addOutputState(outputState, EventContract.ID);

            // Ensure that this flow is being executed by event organizer.
            if (!inputStateToUpdate.getOrganizer().getAgency().getOwningKey().equals(getOurIdentity().getOwningKey())) {
                throw new IllegalArgumentException("This flow must be run by the event organizer.");
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

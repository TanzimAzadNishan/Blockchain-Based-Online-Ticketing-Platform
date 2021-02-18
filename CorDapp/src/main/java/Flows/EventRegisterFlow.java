package Flows;

import Contracts.EventContract;
import Contracts.TicketContract;
import States.EventState;
import co.paralleluniverse.fibers.Suspendable;
import net.corda.core.contracts.Command;
import net.corda.core.flows.*;
import net.corda.core.identity.Party;
import net.corda.core.transactions.SignedTransaction;
import net.corda.core.transactions.TransactionBuilder;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EventRegisterFlow {

    @InitiatingFlow
    @StartableByRPC
    public static class EventRegisterFlowInitiator extends FlowLogic<SignedTransaction>{

        private final String eventDate;
        private final int totalTickets;

        public EventRegisterFlowInitiator(String eventDate, int totalTickets) {
            this.eventDate = eventDate;
            this.totalTickets = totalTickets;
        }

        @Suspendable
        @Override
        public SignedTransaction call() throws FlowException {
            Party notary = getServiceHub().getNetworkMapCache().getNotaryIdentities().get(0);
            Party organizer = getOurIdentity();

            EventState eventState = new EventState(organizer, eventDate, totalTickets);
            final TransactionBuilder builder = new TransactionBuilder(notary);

            List<PublicKey> requiredSigners = new ArrayList<>();
            requiredSigners.add(organizer.getOwningKey());

            Command<EventContract.Commands.Register> command =
                    new Command<>(new EventContract.Commands.Register(), requiredSigners);

            builder.addCommand(command);
            builder.addOutputState(eventState, EventContract.ID);
            builder.verify(getServiceHub());

            final SignedTransaction partiallySignedTx = getServiceHub().signInitialTransaction(builder);

            // Collect the other party's signature using the SignTransactionFlow.
            List<Party> otherParties = eventState.getParticipants()
                    .stream().map(el -> (Party)el)
                    .collect(Collectors.toList());

            otherParties.remove(getOurIdentity());

            List<FlowSession> sessions = otherParties
                    .stream().map(el -> initiateFlow(el))
                    .collect(Collectors.toList());

            SignedTransaction fullySignedTx = subFlow(new CollectSignaturesFlow(partiallySignedTx, sessions));

            // Assuming no exceptions, we can now finalise the transaction
            return subFlow(new FinalityFlow(fullySignedTx, sessions));
        }
    }
}

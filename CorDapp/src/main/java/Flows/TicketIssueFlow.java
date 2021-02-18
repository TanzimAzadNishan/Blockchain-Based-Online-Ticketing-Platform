package Flows;

import Contracts.TicketContract;
import States.TicketState;
import co.paralleluniverse.fibers.Suspendable;
import net.corda.core.contracts.Command;
import net.corda.core.contracts.CommandData;
import net.corda.core.flows.*;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import net.corda.core.transactions.SignedTransaction;
import net.corda.core.transactions.TransactionBuilder;
import net.corda.core.utilities.ProgressTracker;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TicketIssueFlow {

    @InitiatingFlow
    @StartableByRPC
    public static class TicketIssueFlowInitiator extends FlowLogic<SignedTransaction>{

        private final int price;
        private final int refundAmount;
        private final String eventDate;

        public TicketIssueFlowInitiator(int price, int refundAmount, String eventDate) {
            this.price = price;
            this.refundAmount = refundAmount;
            this.eventDate = eventDate;
        }

        /*private final ProgressTracker progressTracker = new ProgressTracker();
        @Override
        public ProgressTracker getProgressTracker() {
            return progressTracker;
        }*/

        @Suspendable
        @Override
        public SignedTransaction call() throws FlowException {

            Party notary = getServiceHub().getNetworkMapCache().getNotaryIdentities().get(0);
            Party ticketIssuer = getOurIdentity();

            TicketState ticketState = new TicketState(ticketIssuer, price, refundAmount, eventDate);
            final TransactionBuilder builder = new TransactionBuilder(notary);

            List<PublicKey> requiredSigners = new ArrayList<>();
            requiredSigners.add(ticketIssuer.getOwningKey());

            Command<TicketContract.Commands.Issue> command =
                    new Command<>(new TicketContract.Commands.Issue(), requiredSigners);

            builder.addCommand(command);
            builder.addOutputState(ticketState, TicketContract.ID);
            builder.verify(getServiceHub());

            final SignedTransaction partiallySignedTx = getServiceHub().signInitialTransaction(builder);


            // Collect the other party's signature using the SignTransactionFlow.
            List<Party> otherParties = ticketState.getParticipants()
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

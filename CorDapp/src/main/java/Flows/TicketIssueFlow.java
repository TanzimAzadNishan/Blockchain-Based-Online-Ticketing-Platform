package Flows;

import Contracts.TicketContract;
import States.EventState;
import States.TicketState;
import States.VendorState;
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

public class TicketIssueFlow {

    @InitiatingFlow
    @StartableByRPC
    public static class TicketIssueFlowInitiator extends FlowLogic<SignedTransaction>{

        private final UniqueIdentifier vendorLinearId;
        private final UniqueIdentifier eventLinearId;
        private final int noOfTicketsToBeIssued;
        private final double price;
        private final double refundAmount;
        private final String eventDate;

        public TicketIssueFlowInitiator(UniqueIdentifier vendorLinearId, UniqueIdentifier eventLinearId, int noOfTicketsToBeIssued, double price,
                                        double refundAmount, String eventDate) {
            this.vendorLinearId = vendorLinearId;
            this.eventLinearId = eventLinearId;
            this.noOfTicketsToBeIssued = noOfTicketsToBeIssued;
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

            // 1. Retrieve the VendorState from the vault using LinearStateQueryCriteria
            /*List<UUID> listOfVendorIds = new ArrayList<>();
            listOfVendorIds.add(vendorLinearId.getId());
            QueryCriteria queryCriteriaVendor =
                    new QueryCriteria.LinearStateQueryCriteria(null, listOfVendorIds);

            // 2. Get a reference to the inputState data that we are going to settle.
            Vault.Page vendorResults = getServiceHub().getVaultService().queryBy(
                    VendorState.class, queryCriteriaVendor
            );
            StateAndRef vendorStateRef = (StateAndRef) vendorResults.getStates().get(0);
            VendorState vendorState = (VendorState) vendorStateRef.getState().getData();


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
            EventState eventState = (EventState) eventStateRef.getState().getData();*/


            Party notary = getServiceHub().getNetworkMapCache().getNotaryIdentities().get(0);
            Party ticketIssuer = getOurIdentity();
            //List<TicketState> allTickets = new ArrayList<>();

            final TransactionBuilder builder = new TransactionBuilder(notary);

            for(int i = 0; i < noOfTicketsToBeIssued; i++){
                TicketState ticketState = new TicketState(ticketIssuer, price, refundAmount, eventDate, vendorLinearId,
                        eventLinearId);
                //allTickets.add(ticketState);
                builder.addOutputState(ticketState, TicketContract.ID);
            }


            //Update VendorState and EventState
            //vendorState.addTicketsToAEvent(allTickets, eventLinearId);
            //eventState.setIssuedTickets(allTickets);

            List<PublicKey> requiredSigners = new ArrayList<>();
            requiredSigners.add(ticketIssuer.getOwningKey());

            Command<TicketContract.Commands.Issue> command =
                    new Command<>(new TicketContract.Commands.Issue(), requiredSigners);

            builder.addCommand(command);
            builder.verify(getServiceHub());

            //final SignedTransaction signedTx = getServiceHub().signInitialTransaction(builder);
            //return signedTx;

            // Collect the other party's signature using the SignTransactionFlow.
            /*List<Party> otherParties = allTickets.get(0).getParticipants()
                    .stream().map(el -> (Party)el)
                    .collect(Collectors.toList());

            otherParties.remove(getOurIdentity());

            List<FlowSession> sessions = otherParties
                    .stream().map(el -> initiateFlow(el))
                    .collect(Collectors.toList());*/
            List<FlowSession> sessions = new ArrayList<>();

            final SignedTransaction signedTx = getServiceHub().signInitialTransaction(builder);
            SignedTransaction fullySignedTx = subFlow(new CollectSignaturesFlow(signedTx, sessions));

            //  Return the output of the FinalityFlow which sends the transaction to the notary for verification
            //  and the causes it to be persisted to the vault of appropriate nodes.
            return subFlow(new FinalityFlow(fullySignedTx, sessions));
        }
    }
}

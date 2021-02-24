package Flows;

import Contracts.EventContract;
import Contracts.VendorContract;
import States.EventState;
import States.VendorState;
import co.paralleluniverse.fibers.Suspendable;
import com.google.common.collect.ImmutableList;
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

public class EventRegisterFlow {

    @InitiatingFlow
    @StartableByRPC
    public static class EventRegisterFlowInitiator extends FlowLogic<UniqueIdentifier>{

        private final UniqueIdentifier vendorLinearId;
        private final String eventDate;
        private final int totalTickets;

        public EventRegisterFlowInitiator(UniqueIdentifier vendorLinearId, String eventDate, int totalTickets) {
            this.vendorLinearId = vendorLinearId;
            this.eventDate = eventDate;
            this.totalTickets = totalTickets;
        }

        @Suspendable
        @Override
        public UniqueIdentifier call() throws FlowException {

            // 1. Retrieve the VendorState from the vault using LinearStateQueryCriteria
            List<UUID> listOfVendorIds = new ArrayList<>();
            listOfVendorIds.add(vendorLinearId.getId());
            QueryCriteria queryCriteriaVendor = new QueryCriteria.LinearStateQueryCriteria(null,
                    listOfVendorIds);
            /*QueryCriteria queryCriteriaVendor =
                    new QueryCriteria.LinearStateQueryCriteria(null, ImmutableList.of(vendorLinearId),
                            Vault.StateStatus.UNCONSUMED,  null);
            List<StateAndRef<VendorState>> stateAndRefList = getServiceHub().getVaultService().queryBy(VendorState.class,
                    queryCriteriaVendor).getStates();

            if (stateAndRefList.size() != 1) {
                throw new FlowException(stateAndRefList.size() + "  " + stateAndRefList.toString());
            }

            VendorState vendorState = stateAndRefList.get(0).getState().getData();
            if(vendorState == null){
                throw new FlowException("vendor state is null");
            }*/

            // 2. Get a reference to the inputState data that we are going to settle.
            Vault.Page vendorResults = getServiceHub().getVaultService().queryBy(VendorState.class, queryCriteriaVendor);
            StateAndRef vendorStateRef = (StateAndRef) vendorResults.getStates().get(0);
            VendorState vendorState = (VendorState) vendorStateRef.getState().getData();


            Party notary = getServiceHub().getNetworkMapCache().getNotaryIdentities().get(0);
            Party organizer = getOurIdentity();

            EventState eventState = new EventState(vendorState, eventDate, totalTickets, vendorLinearId);
            final TransactionBuilder builder = new TransactionBuilder(notary);

            //Update VendorState
            //vendorState.addNewEvent(eventState);

            List<PublicKey> requiredSigners = new ArrayList<>();
            requiredSigners.add(organizer.getOwningKey());

            /*Party vendorStateTxNotary = getServiceHub().getNetworkMapCache().getNotaryIdentities().get(1);
            final TransactionBuilder vendorStateTxBuilder = new TransactionBuilder(vendorStateTxNotary);
            Command<VendorContract.Commands.Update> vendorStateTxCommand =
                    new Command<>(new VendorContract.Commands.Update(), requiredSigners);
            vendorStateTxBuilder.addCommand(vendorStateTxCommand);
            vendorStateTxBuilder.addInputState(vendorStateRef);
            vendorStateTxBuilder.addOutputState(vendorState.withNewEvent(eventState), VendorContract.ID);
            vendorStateTxBuilder.verify(getServiceHub());

            List<FlowSession> vendorStateTxSessions = new ArrayList<>();
            final SignedTransaction vendorStateTxPTx = getServiceHub().signInitialTransaction(builder);
            SignedTransaction vendorStateTxSTx = subFlow(new CollectSignaturesFlow(vendorStateTxPTx, vendorStateTxSessions));
            subFlow(new FinalityFlow(vendorStateTxSTx, vendorStateTxSessions));*/


            Command<EventContract.Commands.Register> command =
                    new Command<>(new EventContract.Commands.Register(), requiredSigners);
            builder.addCommand(command);
            builder.addOutputState(eventState, EventContract.ID);
            builder.verify(getServiceHub());

            List<FlowSession> sessions = new ArrayList<>();

            final SignedTransaction signedTx = getServiceHub().signInitialTransaction(builder);
            SignedTransaction fullySignedTx = subFlow(new CollectSignaturesFlow(signedTx, sessions));

            //  Return the output of the FinalityFlow which sends the transaction to the notary for verification
            //  and the causes it to be persisted to the vault of appropriate nodes.
            subFlow(new FinalityFlow(fullySignedTx, sessions));
            return eventState.getLinearId();
        }
    }
}

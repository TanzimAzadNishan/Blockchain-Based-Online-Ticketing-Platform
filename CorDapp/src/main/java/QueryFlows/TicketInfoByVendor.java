package QueryFlows;

import States.TicketState;
import co.paralleluniverse.fibers.Suspendable;
import net.corda.core.contracts.StateAndRef;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.flows.FlowException;
import net.corda.core.flows.FlowLogic;
import net.corda.core.flows.InitiatingFlow;
import net.corda.core.flows.StartableByRPC;

import java.util.ArrayList;
import java.util.List;

public class TicketInfoByVendor {

    @InitiatingFlow
    @StartableByRPC
    public static class TicketInfoByVendorInitiator extends FlowLogic<String>{

        private final UniqueIdentifier vendorLinearId;

        public TicketInfoByVendorInitiator(UniqueIdentifier vendorLinearId) {
            this.vendorLinearId = vendorLinearId;
        }

        @Suspendable
        @Override
        public String call() throws FlowException {

            List<StateAndRef<TicketState>> allStateAndRefs =
                    getServiceHub().getVaultService().queryBy(TicketState.class).getStates();

            List<TicketState> allTicketStates = new ArrayList<>();

            for(StateAndRef<TicketState> ref : allStateAndRefs){
                TicketState ticketState = ref.getState().getData();

                if(ticketState.getVendorId().equals(vendorLinearId)){
                    allTicketStates.add(ticketState);
                }
            }

            System.out.println("all tickets by vendor id : " + allTicketStates.toString());

            return allTicketStates.toString();
        }
    }
}

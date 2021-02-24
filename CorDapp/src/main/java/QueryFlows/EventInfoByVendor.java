package QueryFlows;

import States.EventState;
import co.paralleluniverse.fibers.Suspendable;
import net.corda.core.contracts.StateAndRef;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.flows.FlowException;
import net.corda.core.flows.FlowLogic;
import net.corda.core.flows.InitiatingFlow;
import net.corda.core.flows.StartableByRPC;

import java.util.ArrayList;
import java.util.List;

public class EventInfoByVendor {

    @InitiatingFlow
    @StartableByRPC
    public static class EventInfoByVendorInitiator extends FlowLogic<String>{

        private final UniqueIdentifier vendorLinearId;

        public EventInfoByVendorInitiator(UniqueIdentifier vendorLinearId) {
            this.vendorLinearId = vendorLinearId;
        }

        @Suspendable
        @Override
        public String call() throws FlowException {

            List<StateAndRef<EventState>> allStateAndRefs =
                    getServiceHub().getVaultService().queryBy(EventState.class).getStates();

            List<EventState> allEventStates = new ArrayList<>();

            System.out.println("Size of allstateref is : " + allStateAndRefs.size());

            for(StateAndRef<EventState> ref : allStateAndRefs){
                EventState eventState = ref.getState().getData();

                System.out.println("event's vendor id : " + eventState.getVendorId());

                if(eventState.getVendorId().equals(vendorLinearId)){
                    allEventStates.add(eventState);
                }
            }

            System.out.println("all events by vendor id : " + allEventStates.toString());

            return allEventStates.toString();
        }
    }
}

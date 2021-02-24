package QueryFlows;

import States.TicketState;
import net.corda.core.contracts.StateAndRef;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.flows.FlowException;
import net.corda.core.flows.FlowLogic;
import net.corda.core.flows.InitiatingFlow;
import net.corda.core.flows.StartableByRPC;

import java.util.ArrayList;
import java.util.List;

public class TicketByEventId {

    @InitiatingFlow
    @StartableByRPC
    public static class TicketByEventIdInitiator extends FlowLogic<String>{

        private final UniqueIdentifier eventLinearId;

        public TicketByEventIdInitiator(UniqueIdentifier eventLinearId) {
            this.eventLinearId = eventLinearId;
        }

        @Override
        public String call() throws FlowException {

            List<StateAndRef<TicketState>> allStateAndRefs =
                    getServiceHub().getVaultService().queryBy(TicketState.class).getStates();

            List<TicketState> allTicketStates = new ArrayList<>();

            for(StateAndRef<TicketState> ref : allStateAndRefs){
                TicketState ticketState = ref.getState().getData();

                if(ticketState.getEventId().equals(eventLinearId)){
                    allTicketStates.add(ticketState);
                }
            }

            System.out.println("all tickets by event id : " + allTicketStates.toString());

            return allTicketStates.toString();
        }
    }
}

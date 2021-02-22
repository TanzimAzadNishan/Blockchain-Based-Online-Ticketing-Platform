package QueryFlows;

import States.TicketState;
import co.paralleluniverse.fibers.Suspendable;
import net.corda.core.contracts.StateAndRef;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.flows.FlowException;
import net.corda.core.flows.FlowLogic;
import net.corda.core.flows.InitiatingFlow;
import net.corda.core.flows.StartableByRPC;
import net.corda.core.node.services.Vault;
import net.corda.core.node.services.vault.QueryCriteria;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TicketByLinearId {
    @InitiatingFlow
    @StartableByRPC
    public static class TicketByLinearIdInitiator extends FlowLogic<String>{

        private final UniqueIdentifier ticketLinearId;

        public TicketByLinearIdInitiator(UniqueIdentifier ticketLinearId) {
            this.ticketLinearId = ticketLinearId;
        }

        @Suspendable
        @Override
        public String call() throws FlowException {

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
            TicketState ticketState = (TicketState) inputStateAndRefToSell.getState().getData();

            System.out.println("ticket state is : " + ticketState.toString());

            return ticketState.toString();
        }
    }
}

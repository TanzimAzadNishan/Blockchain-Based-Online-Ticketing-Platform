package Flows;

import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.flows.FlowException;
import net.corda.core.flows.FlowLogic;
import net.corda.core.flows.InitiatingFlow;
import net.corda.core.flows.StartableByRPC;
import net.corda.core.transactions.SignedTransaction;

public class VendorUpdateFlow {

    @InitiatingFlow
    @StartableByRPC
    public static class EventUpdateFlowInitiator extends FlowLogic<SignedTransaction>{

        //private final UniqueIdentifier eventLinearId;

        @Override
        public SignedTransaction call() throws FlowException {
            return null;
        }
    }
}

package QueryFlows;

import States.VendorState;
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

public class VendorByLinearId {
    @InitiatingFlow
    @StartableByRPC
    public static class VendorByLinearIdInitiator extends FlowLogic<String>{

        private final UniqueIdentifier vendorLinearId;

        public VendorByLinearIdInitiator(UniqueIdentifier vendorLinearId) {
            this.vendorLinearId = vendorLinearId;
        }

        @Suspendable
        @Override
        public String call() throws FlowException {

            // 1. Retrieve the VendorState from the vault using LinearStateQueryCriteria
            List<UUID> listOfVendorIds = new ArrayList<>();
            listOfVendorIds.add(vendorLinearId.getId());
            QueryCriteria queryCriteriaVendor =
                    new QueryCriteria.LinearStateQueryCriteria(null, listOfVendorIds);

            // 2. Get a reference to the inputState data that we are going to settle.
            Vault.Page vendorResults = getServiceHub().getVaultService().queryBy(
                    VendorState.class, queryCriteriaVendor
            );
            StateAndRef vendorStateRef = (StateAndRef) vendorResults.getStates().get(0);
            VendorState vendorState = (VendorState) vendorStateRef.getState().getData();

            System.out.println("Vendor state by vendor id : " + vendorState.toString());

            return vendorState.toString();
        }
    }
}

package QueryFlows;

import States.UserState;
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

public class UserByLinearId {
    @InitiatingFlow
    @StartableByRPC
    public static class UserByLinearIdInitiator extends FlowLogic<String>{

        private final UniqueIdentifier userLinearId;

        public UserByLinearIdInitiator(UniqueIdentifier userLinearId) {
            this.userLinearId = userLinearId;
        }

        @Suspendable
        @Override
        public String call() throws FlowException {

            // 1. Retrieve the UserState from the vault using LinearStateQueryCriteria
            List<UUID> listOfUserIds = new ArrayList<>();
            listOfUserIds.add(userLinearId.getId());
            QueryCriteria queryCriteriaUser =
                    new QueryCriteria.LinearStateQueryCriteria(null, listOfUserIds);

            // 2. Get a reference to the inputState data that we are going to settle.
            Vault.Page userResults = getServiceHub().getVaultService().queryBy(
                    UserState.class, queryCriteriaUser
            );
            StateAndRef userStateRef = (StateAndRef) userResults.getStates().get(0);
            UserState userState = (UserState) userStateRef.getState().getData();

            System.out.println("user info by user id : " + userState.toString());

            return userState.toString();
        }
    }
}

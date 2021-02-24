package Flows;

import Contracts.UserContract;
import Contracts.VendorContract;
import States.UserState;
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

public class UserUpdateFlow {

    @InitiatingFlow
    @StartableByRPC
    public static class UserUpdateFlowInitiator extends FlowLogic<SignedTransaction>{

        private final UniqueIdentifier userLinearId;
        private final double amount;
        private final String type;

        public UserUpdateFlowInitiator(UniqueIdentifier userLinearId, double amount, String type) {
            this.userLinearId = userLinearId;
            this.amount = amount;
            this.type = type;
        }

        @Suspendable
        @Override
        public SignedTransaction call() throws FlowException {

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

            Party notary = getServiceHub().getNetworkMapCache().getNotaryIdentities().get(0);
            final TransactionBuilder builder = new TransactionBuilder(notary);

            List<PublicKey> requiredSigners = new ArrayList<>();
            requiredSigners.add(getOurIdentity().getOwningKey());

            Command<UserContract.Commands.Update> command =
                    new Command<>(new UserContract.Commands.Update(), requiredSigners);

            builder.addCommand(command);
            builder.addInputState(userStateRef);

            if(this.type.equals("Buy")) {
                builder.addOutputState(userState.updateBalanceAfterBuy(amount), UserContract.ID);
            }
            else if(this.type.equals("Refund")) {
                builder.addOutputState(userState.updateBalanceAfterRefund(amount), UserContract.ID);
            }
            else if(this.type.equals("Resell")) {
                builder.addOutputState(userState.updateBalanceAfterResell(amount), UserContract.ID);
            }

            // Ensure that this flow is being executed by ticket issuer.
            if (!userState.getUser().getOwningKey().equals(getOurIdentity().getOwningKey())) {
                throw new IllegalArgumentException("This flow must be run by the user.");
            }

            builder.verify(getServiceHub());

            final SignedTransaction partiallySignedTx = getServiceHub().signInitialTransaction(builder);
            List<FlowSession> sessions = new ArrayList<>();

            SignedTransaction fullySignedTx = subFlow(new CollectSignaturesFlow(partiallySignedTx, sessions));

            //  Return the output of the FinalityFlow which sends the transaction to the notary for verification
            //  and the causes it to be persisted to the vault of appropriate nodes.
            return subFlow(new FinalityFlow(fullySignedTx, sessions));
        }
    }
}

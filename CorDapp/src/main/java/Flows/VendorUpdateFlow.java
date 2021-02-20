package Flows;

import Contracts.VendorContract;
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

public class VendorUpdateFlow {

    @InitiatingFlow
    @StartableByRPC
    public static class VendorUpdateFlowInitiator extends FlowLogic<SignedTransaction>{

        private final UniqueIdentifier vendorLinearId;
        private final double amount;
        private final String type;

        public VendorUpdateFlowInitiator(UniqueIdentifier vendorLinearId, double amount, String type) {
            this.vendorLinearId = vendorLinearId;
            this.amount = amount;
            this.type = type;
        }

        @Suspendable
        @Override
        public SignedTransaction call() throws FlowException {
            // 1. Retrieve the VendorState from the vault using LinearStateQueryCriteria
            List<UUID> listOfVendorIds = new ArrayList<>();
            listOfVendorIds.add(vendorLinearId.getId());
            QueryCriteria queryCriteriaVendor = new QueryCriteria.LinearStateQueryCriteria(null,
                    listOfVendorIds);
            // 2. Get a reference to the inputState data that we are going to settle.
            Vault.Page vendorResults = getServiceHub().getVaultService().queryBy(VendorState.class, queryCriteriaVendor);
            StateAndRef vendorStateRef = (StateAndRef) vendorResults.getStates().get(0);
            VendorState vendorState = (VendorState) vendorStateRef.getState().getData();

            Party notary = getServiceHub().getNetworkMapCache().getNotaryIdentities().get(0);
            final TransactionBuilder builder = new TransactionBuilder(notary);

            List<PublicKey> requiredSigners = new ArrayList<>();
            requiredSigners.add(getOurIdentity().getOwningKey());

            Command<VendorContract.Commands.Update> command =
                    new Command<>(new VendorContract.Commands.Update(), requiredSigners);

            builder.addCommand(command);
            builder.addInputState(vendorStateRef);

            if(this.type.equals("Sell")) {
                builder.addOutputState(vendorState.updateBalanceAfterSell(amount), VendorContract.ID);
            }
            else if(this.type.equals("Refund")) {
                builder.addOutputState(vendorState.updateBalanceAfterRefund(amount), VendorContract.ID);
            }

            // Ensure that this flow is being executed by ticket issuer.
            if (!vendorState.getAgency().getOwningKey().equals(getOurIdentity().getOwningKey())) {
                throw new IllegalArgumentException("This flow must be run by the vendor.");
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

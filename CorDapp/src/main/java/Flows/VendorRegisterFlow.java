package Flows;

import Contracts.EventContract;
import Contracts.VendorContract;
import States.VendorState;
import co.paralleluniverse.fibers.Suspendable;
import net.corda.core.contracts.Command;
import net.corda.core.flows.*;
import net.corda.core.identity.Party;
import net.corda.core.transactions.SignedTransaction;
import net.corda.core.transactions.TransactionBuilder;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.singletonList;

public class VendorRegisterFlow {

    @InitiatingFlow
    @StartableByRPC
    public static class VendorRegisterFlowInitiator extends FlowLogic<SignedTransaction>{

        private final double percentage;

        public VendorRegisterFlowInitiator(double percentage) {
            this.percentage = percentage;
        }

        @Suspendable
        @Override
        public SignedTransaction call() throws FlowException {
            Party notary = getServiceHub().getNetworkMapCache().getNotaryIdentities().get(0);
            Party agency = getOurIdentity();

            VendorState vendorState = new VendorState(agency, percentage);
            final TransactionBuilder builder = new TransactionBuilder(notary);

            List<PublicKey> requiredSigners = new ArrayList<>();
            requiredSigners.add(agency.getOwningKey());

            Command<VendorContract.Commands.Register> command =
                    new Command<>(new VendorContract.Commands.Register(), requiredSigners);

            builder.addCommand(command);
            builder.addOutputState(vendorState, VendorContract.ID);
            builder.verify(getServiceHub());

            /*List<Party> otherParties = vendorState.getParticipants()
                    .stream().map(el -> (Party)el)
                    .collect(Collectors.toList());

            otherParties.remove(getOurIdentity());

            List<FlowSession> sessions = otherParties
                    .stream().map(el -> initiateFlow(el))
                    .collect(Collectors.toList());*/
            List<FlowSession> sessions = new ArrayList<>();

            final SignedTransaction signedTx = getServiceHub().signInitialTransaction(builder);
            SignedTransaction fullySignedTx = subFlow(new CollectSignaturesFlow(signedTx, sessions));

            //  Return the output of the FinalityFlow which sends the transaction to the notary for verification
            //  and the causes it to be persisted to the vault of appropriate nodes.
            return subFlow(new FinalityFlow(fullySignedTx, sessions));
        }
    }
}

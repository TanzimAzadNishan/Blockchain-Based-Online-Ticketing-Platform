package Flows;

import Contracts.UserContract;
import Contracts.VendorContract;
import States.UserState;
import co.paralleluniverse.fibers.Suspendable;
import net.corda.core.contracts.Command;
import net.corda.core.flows.*;
import net.corda.core.identity.Party;
import net.corda.core.transactions.SignedTransaction;
import net.corda.core.transactions.TransactionBuilder;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserRegisterFlow {

    @InitiatingFlow
    @StartableByRPC
    public static class UserRegisterFlowInitiator extends FlowLogic<SignedTransaction>{

        public UserRegisterFlowInitiator(){

        }

        @Suspendable
        @Override
        public SignedTransaction call() throws FlowException {
            Party notary = getServiceHub().getNetworkMapCache().getNotaryIdentities().get(0);
            Party user = getOurIdentity();

            UserState userState = new UserState(user);
            final TransactionBuilder builder = new TransactionBuilder(notary);

            List<PublicKey> requiredSigners = new ArrayList<>();
            requiredSigners.add(user.getOwningKey());

            Command<UserContract.Commands.Register> command =
                    new Command<>(new UserContract.Commands.Register(), requiredSigners);

            builder.addCommand(command);
            builder.addOutputState(userState, UserContract.ID);
            builder.verify(getServiceHub());

            /*List<Party> otherParties = userState.getParticipants()
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

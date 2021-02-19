package Contracts;

import States.UserState;
import States.VendorState;
import net.corda.core.contracts.*;
import net.corda.core.transactions.LedgerTransaction;
import org.jetbrains.annotations.NotNull;

import java.security.PublicKey;
import java.util.List;

import static net.corda.core.contracts.ContractsDSL.requireSingleCommand;
import static net.corda.core.contracts.ContractsDSL.requireThat;

public class UserContract  implements Contract {
    public static final String ID = "Contracts.UserContract";

    public interface Commands extends CommandData {
        class Register extends TypeOnlyCommandData implements UserContract.Commands {}
    }

    @Override
    public void verify(@NotNull LedgerTransaction tx) throws IllegalArgumentException {
        if(tx.getCommands().size() != 1){
            throw new IllegalArgumentException("Transaction must have one command");
        }

        CommandWithParties<UserContract.Commands> command = requireSingleCommand(tx.getCommands(), UserContract.Commands.class);
        CommandData commandData = command.getValue();
        List<ContractState> inputs = tx.getInputStates();
        List<ContractState> outputs = tx.getOutputStates();
        List<PublicKey> requiredSigners = command.getSigners();

        if(commandData instanceof UserContract.Commands.Register){
            requireThat(req -> {
                req.using("No inputs should be consumed when registering a vendor.", inputs.size() == 0);
                req.using( "Only one output state should be created when registering a vendor.", outputs.size() == 1);
                req.using("Output must be a UserState.", outputs.get(0) instanceof UserState);

                UserState outputState = (UserState) outputs.get(0);

                req.using("Vendor must be required singer.",
                        requiredSigners.contains(outputState.getUser().getOwningKey()));

                return null;
            });
        }
    }
}

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
        class Update extends TypeOnlyCommandData implements UserContract.Commands {}
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
                req.using("No inputs should be consumed when registering a user.", inputs.size() == 0);
                req.using( "Only one output state should be created when registering a user.", outputs.size() == 1);
                req.using("Output must be a UserState.", outputs.get(0) instanceof UserState);

                UserState outputState = (UserState) outputs.get(0);

                req.using("User must be required signer.",
                        requiredSigners.contains(outputState.getUser().getOwningKey()));

                return null;
            });
        }
        else if(commandData instanceof UserContract.Commands.Update){
            requireThat(req -> {
                req.using("No inputs should be consumed when updating user state.", inputs.size() == 1);
                req.using( "Only one output state should be created when updating user state.", outputs.size() == 1);
                req.using("Input must be a UserState.", inputs.get(0) instanceof UserState);
                req.using("Output must be a UserState.", outputs.get(0) instanceof UserState);

                UserState inputState = (UserState) inputs.get(0);
                UserState outputState = (UserState) outputs.get(0);

                req.using("A User's linear id is unique",
                        inputState.getLinearId().equals(outputState.getLinearId()));
                req.using("User must be required signer.",
                        requiredSigners.contains(inputState.getUser().getOwningKey()));

                return null;
            });
        }
        else {
            throw new IllegalArgumentException("Command is not recognised");
        }
    }
}

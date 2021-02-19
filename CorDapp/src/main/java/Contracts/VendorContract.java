package Contracts;

import States.EventState;
import States.VendorState;
import net.corda.core.contracts.*;
import net.corda.core.transactions.LedgerTransaction;
import org.jetbrains.annotations.NotNull;

import java.security.PublicKey;
import java.util.List;

import static net.corda.core.contracts.ContractsDSL.requireSingleCommand;
import static net.corda.core.contracts.ContractsDSL.requireThat;

public class VendorContract implements Contract {

    public static final String ID = "Contracts.VendorContract";

    public interface Commands extends CommandData {
        class Register extends TypeOnlyCommandData implements VendorContract.Commands {}
        class Update extends TypeOnlyCommandData implements VendorContract.Commands {}
    }

    @Override
    public void verify(@NotNull LedgerTransaction tx) throws IllegalArgumentException {
        if(tx.getCommands().size() != 1){
            throw new IllegalArgumentException("Transaction must have one command");
        }

        CommandWithParties<VendorContract.Commands> command = requireSingleCommand(tx.getCommands(), VendorContract.Commands.class);
        CommandData commandData = command.getValue();
        List<ContractState> inputs = tx.getInputStates();
        List<ContractState> outputs = tx.getOutputStates();
        List<PublicKey> requiredSigners = command.getSigners();

        if(commandData instanceof VendorContract.Commands.Register){
            requireThat(req -> {
                req.using("No inputs should be consumed when registering a vendor.", inputs.size() == 0);
                req.using( "Only one output state should be created when registering a vendor.", outputs.size() == 1);
                req.using("Output must be a VendorState.", outputs.get(0) instanceof VendorState);

                VendorState outputState = (VendorState) outputs.get(0);

                req.using("Vendor must be required singer.",
                        requiredSigners.contains(outputState.getAgency().getOwningKey()));
                req.using("Percentage must be positive.", outputState.getPercentage() > 0);

                return null;
            });
        }

        else if(commandData instanceof VendorContract.Commands.Update){
            requireThat(req -> {
                req.using("No inputs should be consumed when updating vendor state.", inputs.size() == 1);
                req.using( "Only one output state should be created when updating vendor state.", outputs.size() == 1);
                req.using("Input must be a VendorState.", inputs.get(0) instanceof VendorState);
                req.using("Output must be a VendorState.", outputs.get(0) instanceof VendorState);

                VendorState inputState = (VendorState) inputs.get(0);
                VendorState outputState = (VendorState) outputs.get(0);

                req.using("A Vendor's linear id is unique",
                        inputState.getLinearId().equals(outputState.getLinearId()));
                req.using("Vendor must be required singer.",
                        requiredSigners.contains(inputState.getAgency().getOwningKey()));

                return null;
            });
        }
        else {
            throw new IllegalArgumentException("Command is not recognised");
        }
    }
}

package Contracts;

import States.EventState;
import States.TicketState;
import net.corda.core.contracts.*;
import net.corda.core.transactions.LedgerTransaction;
import org.jetbrains.annotations.NotNull;

import java.security.PublicKey;
import java.util.List;

import static net.corda.core.contracts.ContractsDSL.requireSingleCommand;
import static net.corda.core.contracts.ContractsDSL.requireThat;

public class EventContract implements Contract {
    public static final String ID = "Contracts.EventContract";

    public interface Commands extends CommandData {
        class Register extends TypeOnlyCommandData implements TicketContract.Commands {}
        class Update extends TypeOnlyCommandData implements TicketContract.Commands {}
    }
    @Override
    public void verify(@NotNull LedgerTransaction tx) throws IllegalArgumentException {
        if(tx.getCommands().size() != 1){
            throw new IllegalArgumentException("Transaction must have one command");
        }

        CommandWithParties<EventContract.Commands> command = requireSingleCommand(tx.getCommands(), EventContract.Commands.class);
        CommandData commandData = command.getValue();
        List<ContractState> inputs = tx.getInputStates();
        List<ContractState> outputs = tx.getOutputStates();
        List<PublicKey> requiredSigners = command.getSigners();

        if(commandData instanceof Commands.Register){
            requireThat(req -> {
                req.using("No inputs should be consumed when issuing a ticket.", inputs.size() == 0);
                req.using( "Only one output state should be created when issuing a ticket.", outputs.size() == 1);
                req.using("Output must be a TicketState.", outputs.get(0) instanceof EventState);

                EventState outputState = (EventState) outputs.get(0);

                req.using("Issuer must be required singer.",
                        requiredSigners.contains(outputState.getOrganizer().getOwningKey()));
                req.using("Total no. of tickets must be positive.", outputState.getTotalTickets() > 0);
                req.using("There must be an event date.", !(outputState.getEventDate().equals("")));

                return null;
            });
        }
        else if(commandData instanceof Commands.Update){

        }
        else {
            throw new IllegalArgumentException("Command is not recognised");
        }
    }
}

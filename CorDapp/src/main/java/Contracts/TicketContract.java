package Contracts;

import States.TicketState;
import net.corda.core.contracts.*;
import net.corda.core.transactions.LedgerTransaction;
import org.jetbrains.annotations.NotNull;

import java.security.PublicKey;
import java.util.List;

import static net.corda.core.contracts.ContractsDSL.requireSingleCommand;

public class TicketContract implements Contract {
    public static final String TICKET_CONTRACT_ID = "Contracts.TicketContract";

    public class Issue implements CommandData{}
    public class Sell implements CommandData{}
    public class Refund implements CommandData{}
    public class Resell implements CommandData{}
    public class Update implements CommandData{}

    @Override
    public void verify(@NotNull LedgerTransaction tx) throws IllegalArgumentException {
        if(tx.getCommands().size() != 1){
            throw new IllegalArgumentException("Transaction must have one command");
        }

        Command command = tx.getCommand(0);
        CommandData commandData = command.getValue();
        List<PublicKey> requiredSigners = command.getSigners();

        if(commandData instanceof Issue){
            if(tx.getInputStates().size() != 0){
                throw new IllegalArgumentException("No inputs should be consumed when issuing a ticket");
            }
            if(tx.getOutputStates().size() != 1){
                throw new IllegalArgumentException("Only one output state should be created when issuing");
            }

            ContractState outputState = tx.getOutput(0);
            if(!(outputState instanceof TicketState)){
                throw new IllegalArgumentException("Output must be a TicketState");
            }

            TicketState ticketState = (TicketState) outputState;

            // constraints

        }

        else if(commandData instanceof Sell){

        }
        else if(commandData instanceof Refund){

        }
        else if(commandData instanceof Resell){

        }
        else if(commandData instanceof Update){

        }
        else {
            throw new IllegalArgumentException("Command type not recognised");
        }
    }
}

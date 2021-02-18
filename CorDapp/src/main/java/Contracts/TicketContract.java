package Contracts;

import States.TicketState;
import net.corda.core.contracts.*;
import net.corda.core.transactions.LedgerTransaction;
import org.jetbrains.annotations.NotNull;

import java.security.PublicKey;
import java.util.List;

import static net.corda.core.contracts.ContractsDSL.requireSingleCommand;
import static net.corda.core.contracts.ContractsDSL.requireThat;

public class TicketContract implements Contract {
    public static final String TICKET_CONTRACT_ID = "Contracts.TicketContract";

    public interface Commands extends CommandData {
        class Issue extends TypeOnlyCommandData implements Commands{}
        class Sell extends TypeOnlyCommandData implements Commands{}
        class Refund extends TypeOnlyCommandData implements Commands{}
        class ReSell extends TypeOnlyCommandData implements Commands{}
        class Update extends TypeOnlyCommandData implements Commands{}
    }

    @Override
    public void verify(@NotNull LedgerTransaction tx) throws IllegalArgumentException {
        if(tx.getCommands().size() != 1){
            throw new IllegalArgumentException("Transaction must have one command");
        }

        CommandWithParties<Commands> command = requireSingleCommand(tx.getCommands(), Commands.class);
        CommandData commandData = command.getValue();
        List<ContractState> inputs = tx.getInputStates();
        List<ContractState> outputs = tx.getOutputStates();
        //List<PublicKey> requiredSigners = command.getSigners();

        if(commandData instanceof Commands.Issue){
            requireThat(req -> {
                req.using("No inputs should be consumed when issuing a ticket.", inputs.size() == 0);
                req.using( "Only one output state should be created when issuing a ticket.", outputs.size() == 1);
                req.using("Output must be a TicketState.", outputs.get(0) instanceof TicketState);

                TicketState ticketState = (TicketState) outputs.get(0);

                req.using("Issuer must be required singer.", command.getSigners().contains(ticketState.getTicketIssuer().getOwningKey()));
                req.using("Amount must be positive.", ticketState.getPrice() > 0);

                return null;
            });

            /*if(tx.getInputStates().size() != 0){
                throw new IllegalArgumentException("No inputs should be consumed when issuing a ticket");
            }
            if(tx.getOutputStates().size() != 1){
                throw new IllegalArgumentException("Only one output state should be created when issuing");
            }

            ContractState outputState = tx.getOutput(0);
            if(!(outputState instanceof TicketState)){
                throw new IllegalArgumentException("Output must be a TicketState");
            }
            TicketState ticketState = (TicketState) outputState;*/

            // constraints

        }

        else if(commandData instanceof Commands.Sell){

        }
        else if(commandData instanceof Commands.Refund){

        }
        else if(commandData instanceof Commands.ReSell){

        }
        else if(commandData instanceof Commands.Update){

        }
        else {
            throw new IllegalArgumentException("Command type not recognised");
        }
    }
}

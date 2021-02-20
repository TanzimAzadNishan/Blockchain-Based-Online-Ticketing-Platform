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
    public static final String ID = "Contracts.TicketContract";

    public interface Commands extends CommandData {
        class Issue extends TypeOnlyCommandData implements Commands{}
        class Sell extends TypeOnlyCommandData implements Commands{}
        class Refund extends TypeOnlyCommandData implements Commands{}
        class Resell extends TypeOnlyCommandData implements Commands{}
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
        List<PublicKey> requiredSigners = command.getSigners();

        if(commandData instanceof Commands.Issue){
            requireThat(req -> {
                req.using("No inputs should be consumed when issuing a ticket.", inputs.size() == 0);
                req.using( "Some output state should be created when issuing a ticket.", outputs.size() > 0);
                req.using("Output must be a TicketState.", outputs.get(0) instanceof TicketState);

                TicketState outputState = (TicketState) outputs.get(0);

                req.using("Issuer must be required singer.",
                        requiredSigners.contains(outputState.getTicketIssuer().getOwningKey()));
                req.using("Price must be positive.", outputState.getPrice() > 0);
                req.using("Refund Amount must be positive.", outputState.getRefundAmount() > 0);
                req.using("There must be an event date.", !(outputState.getEventDate().equals("")));

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
            requireThat(req -> {
                req.using("A Ticket Sell transaction should only consume one input state", inputs.size() == 1);
                req.using( "A Ticket Sell transaction should only consume one output state", outputs.size() == 1);
                req.using("Output must be a TicketState.", outputs.get(0) instanceof TicketState);

                TicketState inputState = (TicketState) inputs.get(0);
                TicketState outputState = (TicketState) outputs.get(0);

                req.using("A Ticket's linear id is unique",
                        inputState.getLinearId().equals(outputState.getLinearId()));
                /*req.using("User must have enough balance to buy a ticket",
                        outputState.getCurrentOwner().getBalance() >= inputState.getPrice());*/
                req.using("Issuer must be required singer.",
                        requiredSigners.contains(inputState.getTicketIssuer().getOwningKey()));
                req.using("Current Owner must be required singer.",
                        requiredSigners.contains(outputState.getCurrentOwner().getOwningKey()));
                req.using("Amount must be positive.", outputState.getPrice() > 0);

                return null;
            });
        }
        else if(commandData instanceof Commands.Refund){
            requireThat(req -> {
                req.using("A Ticket Sell transaction should only consume one input state", inputs.size() == 1);
                req.using("A Ticket Sell transaction should only consume one output state", outputs.size() == 1);
                req.using("Output must be a TicketState.", outputs.get(0) instanceof TicketState);

                TicketState inputState = (TicketState) inputs.get(0);
                TicketState outputState = (TicketState) outputs.get(0);

                req.using("A Ticket's linear id is unique",
                        inputState.getLinearId().equals(outputState.getLinearId()));
                req.using("Issuer must be required singer.",
                        requiredSigners.contains(outputState.getTicketIssuer().getOwningKey()));
                req.using("Current Owner must be required singer.",
                        requiredSigners.contains(inputState.getCurrentOwner().getOwningKey()));
                req.using("Amount must be positive.", outputState.getRefundAmount() > 0);

                return null;
            });
        }
        else if(commandData instanceof Commands.Resell){
            requireThat(req -> {
                req.using("A Ticket Sell transaction should only consume one input state", inputs.size() == 1);
                req.using("A Ticket Sell transaction should only consume one output state", outputs.size() == 1);
                req.using("Output must be a TicketState.", outputs.get(0) instanceof TicketState);

                TicketState inputState = (TicketState) inputs.get(0);
                TicketState outputState = (TicketState) outputs.get(0);

                req.using("A Ticket's linear id is unique",
                        inputState.getLinearId().equals(outputState.getLinearId()));
                req.using("Previous owner and current owner must be different",
                        inputState.getCurrentOwner().getOwningKey() !=
                                outputState.getCurrentOwner().getOwningKey());
                /*req.using("User must have enough balance to buy a ticket",
                         outputState.getCurrentOwner().getBalance() >= inputState.getPrice());*/
                req.using("Previous Owner must be required singer.",
                        requiredSigners.contains(inputState.getCurrentOwner().getOwningKey()));
                req.using("Current Owner must be required singer.",
                        requiredSigners.contains(outputState.getCurrentOwner().getOwningKey()));
                req.using("Amount must be positive.", outputState.getPrice() > 0);

                return null;
            });
        }

        else if(commandData instanceof Commands.Update){
            requireThat(req -> {
                req.using("A Ticket Update transaction should only consume one input state", inputs.size() == 1);
                req.using("A Ticket Update transaction should only consume one output state", outputs.size() == 1);
                req.using("Output must be a TicketState.", outputs.get(0) instanceof TicketState);

                TicketState inputState = (TicketState) inputs.get(0);
                TicketState outputState = (TicketState) outputs.get(0);

                req.using("A Ticket's linear id is unique",
                        inputState.getLinearId().equals(outputState.getLinearId()));
                req.using("Issuer must be required singer.",
                        requiredSigners.contains(inputState.getTicketIssuer().getOwningKey()));
                req.using("There must be an event date.", !(outputState.getEventDate().equals("")));

                return null;
            });
        }
        else {
            throw new IllegalArgumentException("Command type not recognised");
        }
    }
}

package States;

import net.corda.core.contracts.ContractState;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class EventState implements ContractState {
    // The attributes that will be stored on the ledger as part of the state.
    private Party organizer;
    private List<TicketState> soldTickets;
    private int totalTickets;
    private int remainingTickets;
    private String eventDate;

    @NotNull
    @Override
    public List<AbstractParty> getParticipants() {
        return null;
    }
}

package States;

import com.google.common.collect.ImmutableList;
import javafx.util.Pair;
import net.corda.core.contracts.ContractState;
import net.corda.core.contracts.LinearState;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class EventState implements ContractState, LinearState {
    // The attributes that will be stored on the ledger as part of the state.
    private Party organizer;
    private List<TicketState> issuedTickets;
    private List<TicketState> soldTickets;
    private int totalTickets;
    private int remainingTickets;
    private String eventDate;
    private UniqueIdentifier linearId;

    @NotNull
    @Override
    public List<AbstractParty> getParticipants() {
        return ImmutableList.of(organizer);
    }

    @NotNull
    @Override
    public UniqueIdentifier getLinearId() {
        return linearId;
    }
}

package States;

import Contracts.EventContract;
import Contracts.TicketContract;
import com.google.common.collect.ImmutableList;
import javafx.util.Pair;
import net.corda.core.contracts.BelongsToContract;
import net.corda.core.contracts.ContractState;
import net.corda.core.contracts.LinearState;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import net.corda.core.serialization.ConstructorForDeserialization;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@BelongsToContract(EventContract.class)
public class EventState implements ContractState, LinearState {
    // The attributes that will be stored on the ledger as part of the state.
    private Party organizer;
    private String eventDate;
    private List<TicketState> issuedTickets;
    private List<TicketState> soldTickets;
    private int totalTickets;
    private int remainingTickets;
    private UniqueIdentifier linearId;


    @ConstructorForDeserialization
    private EventState(Party organizer, String eventDate, List<TicketState> issuedTickets, List<TicketState> soldTickets, int totalTickets, int remainingTickets, UniqueIdentifier linearId) {
        this.organizer = organizer;
        this.eventDate = eventDate;
        this.issuedTickets = issuedTickets;
        this.soldTickets = soldTickets;
        this.totalTickets = totalTickets;
        this.remainingTickets = remainingTickets;
        this.linearId = linearId;
    }

    public EventState(Party organizer, String eventDate, int totalTickets) {
        this(organizer, eventDate, new ArrayList<>(), new ArrayList<>(), totalTickets, totalTickets, new UniqueIdentifier());
    }

    public Party getOrganizer() {
        return organizer;
    }

    public List<TicketState> getIssuedTickets() {
        return issuedTickets;
    }

    public List<TicketState> getSoldTickets() {
        return soldTickets;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public int getRemainingTickets() {
        return remainingTickets;
    }

    public String getEventDate() {
        return eventDate;
    }

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

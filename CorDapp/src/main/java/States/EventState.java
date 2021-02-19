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
    private VendorState organizer;
    private String eventDate;
    private List<TicketState> issuedTickets;
    private List<TicketState> soldTickets;
    private int totalTickets;
    private int remainingTickets;
    private UniqueIdentifier linearId;
    private UniqueIdentifier vendorId;


    @ConstructorForDeserialization
    private EventState(VendorState organizer, String eventDate, List<TicketState> issuedTickets, List<TicketState> soldTickets,
                       int totalTickets, int remainingTickets, UniqueIdentifier linearId, UniqueIdentifier vendorId) {
        this.organizer = organizer;
        this.eventDate = eventDate;
        this.issuedTickets = issuedTickets;
        this.soldTickets = soldTickets;
        this.totalTickets = totalTickets;
        this.remainingTickets = remainingTickets;
        this.linearId = linearId;
        this.vendorId = vendorId;
    }

    public EventState(VendorState organizer, String eventDate, int totalTickets, UniqueIdentifier vendorId) {
        this(organizer, eventDate, new ArrayList<>(), new ArrayList<>(), totalTickets, totalTickets,
                new UniqueIdentifier(), vendorId);
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public void setIssuedTickets(List<TicketState> issuedTickets) {
        this.issuedTickets = issuedTickets;
        this.totalTickets = issuedTickets.size();
        this.remainingTickets = this.totalTickets;
    }

    public void markTicketAsSold(TicketState ticketState) {
        this.soldTickets.add(ticketState);
        this.remainingTickets = this.totalTickets - soldTickets.size();
    }
    public void markTicketAsUnsold(TicketState ticketState) {
        this.soldTickets.remove(ticketState);
        this.remainingTickets = this.totalTickets - soldTickets.size();
    }

    public VendorState getOrganizer() {
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

    public UniqueIdentifier getVendorId() {
        return vendorId;
    }

    @NotNull
    @Override
    public List<AbstractParty> getParticipants() {
        return ImmutableList.of(organizer.getAgency());
    }

    @NotNull
    @Override
    public UniqueIdentifier getLinearId() {
        return linearId;
    }

    public EventState withNewEventDate(String eventDate){
        this.eventDate = eventDate;
        return this;
        //return new EventState(organizer, eventDate, issuedTickets, soldTickets, totalTickets, remainingTickets, linearId);
    }

    public void replaceTicketStateOfAEvent(TicketState ticketState){
        for(TicketState state: soldTickets){
            if(state.getLinearId().equals(ticketState.getLinearId())){
                soldTickets.remove(state);
                break;
            }
        }
        soldTickets.add(ticketState);
    }
}

package States;

import Contracts.TicketContract;
import com.google.common.collect.ImmutableList;
import net.corda.core.contracts.*;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import net.corda.core.serialization.ConstructorForDeserialization;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

@BelongsToContract(TicketContract.class)
public class TicketState implements ContractState, LinearState {
    // The attributes that will be stored on the ledger as part of the state.
    private UserState currentOwner;
    private VendorState ticketIssuer;
    private double price;
    private double refundAmount;
    private String eventDate;
    private UniqueIdentifier linearId;
    private UniqueIdentifier eventId;
    private List<AbstractParty> participants;


    @ConstructorForDeserialization
    private TicketState(UserState currentOwner, VendorState ticketIssuer, double price, double refundAmount,
                        String eventDate, UniqueIdentifier linearId, UniqueIdentifier eventId) {
        this.currentOwner = currentOwner;
        this.ticketIssuer = ticketIssuer;
        this.price = price;
        this.refundAmount = refundAmount;
        this.eventDate = eventDate;
        this.linearId = linearId;
        this.eventId = eventId;

        this.participants = new ArrayList<>();
        participants.add(ticketIssuer.getAgency());
        if(currentOwner != null){
            this.participants.add(currentOwner.getUser());
        }
    }

    public TicketState(VendorState ticketIssuer, double price, double refundAmount, String eventDate, UniqueIdentifier eventId) {
        this(null, ticketIssuer, price, refundAmount, eventDate, new UniqueIdentifier(), eventId);
    }

    public double getRefundAmount() {
        return refundAmount;
    }

    public UserState getCurrentOwner() {
        return currentOwner;
    }

    public VendorState getTicketIssuer() {
        return ticketIssuer;
    }

    public double getPrice() {
        return price;
    }

    public String getEventDate() {
        return eventDate;
    }

    public UniqueIdentifier getEventId() {
        return eventId;
    }

    @NotNull
    @Override
    public List<AbstractParty> getParticipants() {
        return participants;
    }

    @NotNull
    @Override
    public UniqueIdentifier getLinearId() {
        return linearId;
    }

    public TicketState withNewOwner(UserState newOwner){
        this.currentOwner = newOwner;
        this.participants.add(currentOwner.getUser());
        return this;
        //return new TicketState(newOwner, ticketIssuer, price, refundAmount, eventDate, linearId);
    }
    public TicketState withNoOwner(){
        this.participants.remove(currentOwner.getUser());
        this.currentOwner = null;
        return this;
        //return new TicketState(null, ticketIssuer, price, refundAmount, eventDate, linearId);
    }
    public TicketState withNewEventDate(String eventDate){
        this.eventDate = eventDate;
        return this;
        //return new TicketState(currentOwner, ticketIssuer, price, refundAmount, eventDate, linearId);
    }
}

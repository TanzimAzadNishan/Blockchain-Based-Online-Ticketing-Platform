package States;

import Contracts.TicketContract;
import net.corda.core.contracts.*;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import net.corda.core.serialization.ConstructorForDeserialization;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@BelongsToContract(TicketContract.class)
public class TicketState implements ContractState, LinearState {
    // The attributes that will be stored on the ledger as part of the state.
    private Party ticketIssuer;
    private Party currentOwner;
    private double price;
    private double refundAmount;
    private String eventDate;
    private UniqueIdentifier linearId;
    private UniqueIdentifier vendorId;
    private UniqueIdentifier userId;
    private UniqueIdentifier eventId;
    private List<AbstractParty> participants;


    @ConstructorForDeserialization
    public TicketState(Party ticketIssuer, Party currentOwner, double price, double refundAmount, String eventDate,
                       UniqueIdentifier linearId, UniqueIdentifier vendorId, UniqueIdentifier eventId,
                       UniqueIdentifier userId) {
        this.ticketIssuer = ticketIssuer;
        this.currentOwner = currentOwner;
        this.price = price;
        this.refundAmount = refundAmount;
        this.eventDate = eventDate;
        this.linearId = linearId;
        this.vendorId = vendorId;
        this.eventId = eventId;
        this.userId = userId;

        this.participants = new ArrayList<>();
        participants.add(ticketIssuer);
        if(currentOwner != null){
            this.participants.add(currentOwner);
        }
    }


    public TicketState(Party ticketIssuer, double price, double refundAmount, String eventDate,
                       UniqueIdentifier vendorId, UniqueIdentifier eventId) {
        this(ticketIssuer, null, price, refundAmount, eventDate, new UniqueIdentifier(), vendorId, eventId, null);
    }

    public double getRefundAmount() {
        return refundAmount;
    }

    public Party getCurrentOwner() {
        return currentOwner;
    }

    public Party getTicketIssuer() {
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

    public UniqueIdentifier getVendorId() {
        return vendorId;
    }

    public UniqueIdentifier getUserId() {
        return userId;
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

    public TicketState withNewOwner(Party newOwner, UniqueIdentifier userLinearId){
        //this.currentOwner = newOwner;
        //this.participants.add(currentOwner.getUser());
        //return this;
        return new TicketState(ticketIssuer, newOwner, price, refundAmount, eventDate, linearId, vendorId, eventId, userLinearId);
    }
    public TicketState withNoOwner(){
        //this.participants.remove(currentOwner.getUser());
        //this.currentOwner = null;
        //return this;
        return new TicketState(ticketIssuer, null, price, refundAmount, eventDate, linearId, vendorId, eventId, null);
    }
    public TicketState withNewEventDate(String eventDate){
        //this.eventDate = eventDate;
        //return this;
        return new TicketState(ticketIssuer, currentOwner, price, refundAmount, eventDate, linearId, vendorId, eventId, userId);
    }
}

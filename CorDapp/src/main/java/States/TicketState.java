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
    private Party currentOwner;
    private Party ticketIssuer;
    private int price;
    private int refundAmount;
    private String eventDate;
    private UniqueIdentifier linearId;
    private List<AbstractParty> participants;


    @ConstructorForDeserialization
    public TicketState(Party currentOwner, Party ticketIssuer, int price, int refundAmount, String eventDate, UniqueIdentifier linearId) {
        this.currentOwner = currentOwner;
        this.ticketIssuer = ticketIssuer;
        this.price = price;
        this.refundAmount = refundAmount;
        this.eventDate = eventDate;
        this.linearId = linearId;

        this.participants = new ArrayList<>();
        participants.add(ticketIssuer);
        if(currentOwner != null){
            this.participants.add(currentOwner);
        }
    }

    public TicketState(Party ticketIssuer, int price, int refundAmount, String eventDate) {
        this(null, ticketIssuer, price, refundAmount, eventDate, new UniqueIdentifier());
    }

    public int getRefundAmount() {
        return refundAmount;
    }

    public Party getCurrentOwner() {
        return currentOwner;
    }

    public Party getTicketIssuer() {
        return ticketIssuer;
    }

    public int getPrice() {
        return price;
    }

    public String getEventDate() {
        return eventDate;
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

    public TicketState withNewOwner(Party newOwner){
        return new TicketState(newOwner, ticketIssuer, price, refundAmount,
                eventDate, linearId);
    }
    public TicketState withNoOwner(){
        return new TicketState(null, ticketIssuer, price, refundAmount,
                eventDate, linearId);
    }
}

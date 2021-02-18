package States;

import com.google.common.collect.ImmutableList;
import net.corda.core.contracts.Amount;
import net.corda.core.contracts.ContractState;
import net.corda.core.contracts.LinearState;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import org.jetbrains.annotations.NotNull;

import java.util.Currency;
import java.util.List;

public class TicketState implements ContractState, LinearState {
    // The attributes that will be stored on the ledger as part of the state.
    private Party currentOwner;
    private Party ticketIssuer;
    private int price;
    //private String ticketHash;
    private String eventDate;
    private UniqueIdentifier linearId;

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
        return ImmutableList.of(currentOwner, ticketIssuer);
    }

    @NotNull
    @Override
    public UniqueIdentifier getLinearId() {
        return linearId;
    }
}

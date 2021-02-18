package States;

import net.corda.core.contracts.Amount;
import net.corda.core.contracts.ContractState;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import org.jetbrains.annotations.NotNull;

import java.util.Currency;
import java.util.List;

public class TicketState implements ContractState {
    // The attributes that will be stored on the ledger as part of the state.
    private Party currentOwner;
    private Party ticketIssuer;
    private Amount<Currency> price;
    private String ticketHash;
    private String eventDate;

    @NotNull
    @Override
    public List<AbstractParty> getParticipants() {
        return null;
    }
}

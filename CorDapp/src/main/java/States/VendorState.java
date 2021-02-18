package States;

import com.google.common.collect.ImmutableList;
import net.corda.core.contracts.ContractState;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class VendorState implements ContractState {
    // The attributes that will be stored on the ledger as part of the state.
    private Party agency;
    private int rating;
    private int percentage;
    private int totalSales;
    private int noOfOrganizedEvents;
    private List<EventState> allEvents;

    @NotNull
    @Override
    public List<AbstractParty> getParticipants() {
        return ImmutableList.of(agency);
    }
}

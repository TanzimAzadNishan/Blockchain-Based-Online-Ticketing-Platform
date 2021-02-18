package States;

import com.google.common.collect.ImmutableList;
import net.corda.core.contracts.ContractState;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class UserState implements ContractState {
    // The attributes that will be stored on the ledger as part of the state.
    private Party user;
    private int noOfTicketsBought;
    private int noOfTicketsRefunded;
    private int noOfTicketsReSold;


    @NotNull
    @Override
    public List<AbstractParty> getParticipants() {
        return ImmutableList.of(user);
    }
}

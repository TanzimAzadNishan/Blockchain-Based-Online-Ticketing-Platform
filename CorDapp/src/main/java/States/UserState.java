package States;

import Contracts.UserContract;
import Contracts.VendorContract;
import com.google.common.collect.ImmutableList;
import net.corda.core.contracts.Amount;
import net.corda.core.contracts.BelongsToContract;
import net.corda.core.contracts.ContractState;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import net.corda.core.serialization.ConstructorForDeserialization;
import org.jetbrains.annotations.NotNull;
import net.corda.finance.*;

import java.util.Currency;
import java.util.List;

@BelongsToContract(UserContract.class)
public class UserState implements ContractState {
    // The attributes that will be stored on the ledger as part of the state.
    private Party user;
    private int noOfTicketsBought;
    private int noOfTicketsRefunded;
    private int noOfTicketsReSold;
    private double balance;
    private UniqueIdentifier linearId;


    @ConstructorForDeserialization
    private UserState(Party user, int noOfTicketsBought, int noOfTicketsRefunded, int noOfTicketsReSold,
                      double balance, UniqueIdentifier linearId) {
        this.user = user;
        this.noOfTicketsBought = noOfTicketsBought;
        this.noOfTicketsRefunded = noOfTicketsRefunded;
        this.noOfTicketsReSold = noOfTicketsReSold;
        this.balance = balance;
        this.linearId = linearId;
    }

    public UserState(Party user){
        this(user, 0, 0, 0, 100, new UniqueIdentifier());
    }

    public Party getUser() {
        return user;
    }

    public int getNoOfTicketsBought() {
        return noOfTicketsBought;
    }

    public int getNoOfTicketsRefunded() {
        return noOfTicketsRefunded;
    }

    public int getNoOfTicketsReSold() {
        return noOfTicketsReSold;
    }

    public double getBalance() {
        return balance;
    }

    @NotNull
    @Override
    public List<AbstractParty> getParticipants() {
        return ImmutableList.of(user);
    }

    public void increaseBalance(double amount){
        this.balance = this.balance + amount;
    }
    public void decreaseBalance(double amount){
        this.balance = this.balance - amount;
    }
}

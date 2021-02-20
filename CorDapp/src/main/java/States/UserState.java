package States;

import Contracts.UserContract;
import com.google.common.collect.ImmutableList;
import net.corda.core.contracts.BelongsToContract;
import net.corda.core.contracts.ContractState;
import net.corda.core.contracts.LinearState;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import net.corda.core.serialization.ConstructorForDeserialization;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@BelongsToContract(UserContract.class)
public class UserState implements ContractState, LinearState {
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

    public void decreaseBalance(double amount){
        this.balance = this.balance - amount;
    }

    @NotNull
    @Override
    public UniqueIdentifier getLinearId() {
        return null;
    }
    public UserState updateBalanceAfterBuy(double amount){
        return new UserState(user, noOfTicketsBought + 1, noOfTicketsRefunded, noOfTicketsReSold,
                balance - amount, linearId);
    }
    public UserState updateBalanceAfterRefund(double amount){
        return new UserState(user, noOfTicketsBought - 1, noOfTicketsRefunded + 1, noOfTicketsReSold,
                balance + amount, linearId);
    }
    public UserState updateBalanceAfterResell(double amount){
        return new UserState(user, noOfTicketsBought, noOfTicketsRefunded, noOfTicketsReSold + 1,
                balance + amount, linearId);
    }
}

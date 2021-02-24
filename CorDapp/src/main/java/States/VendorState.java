package States;

import Contracts.VendorContract;
import com.google.common.collect.ImmutableList;
import net.corda.core.contracts.*;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import net.corda.core.serialization.ConstructorForDeserialization;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


@BelongsToContract(VendorContract.class)
public class VendorState implements ContractState, LinearState {
    // The attributes that will be stored on the ledger as part of the state.
    private Party agency;
    private double percentage;
    private int totalSales;
    private int noOfOrganizedEvents;
    private List<EventState> allEvents;
    private UniqueIdentifier linearId;
    private double balance;


    @ConstructorForDeserialization
    private VendorState(Party agency, double percentage, int totalSales, int noOfOrganizedEvents, List<EventState> allEvents,
                        double balance, UniqueIdentifier linearId) {
        this.agency = agency;
        this.percentage = percentage;
        this.totalSales = totalSales;
        this.noOfOrganizedEvents = noOfOrganizedEvents;
        this.allEvents = allEvents;
        this.balance = balance;
        this.linearId = linearId;
    }

    public VendorState(Party agency, double percentage) {
        this(agency, percentage, 0, 0, new ArrayList<>(), 300, new UniqueIdentifier());
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public void addNewEvent(EventState event) {
        this.noOfOrganizedEvents++;
        this.allEvents.add(event);
    }

    public Party getAgency() {
        return agency;
    }

    public double getPercentage() {
        return percentage;
    }

    public int getTotalSales() {
        return totalSales;
    }

    public int getNoOfOrganizedEvents() {
        return noOfOrganizedEvents;
    }

    public List<EventState> getAllEvents() {
        return allEvents;
    }

    public double getBalance() {
        return balance;
    }

    @NotNull
    @Override
    public List<AbstractParty> getParticipants() {
        return ImmutableList.of(agency);
    }

    @NotNull
    @Override
    public UniqueIdentifier getLinearId() {
        return linearId;
    }

    public EventState getEventByLinearId(UniqueIdentifier linearId){
        for(EventState event: allEvents){
            if(event.getLinearId().equals(linearId)){
                return event;
            }
        }
        return null;
    }
    public void addTicketsToAEvent(List<TicketState> issuedTickets, UniqueIdentifier linearId) {
        EventState eventState = getEventByLinearId(linearId);
        eventState.setIssuedTickets(issuedTickets);
    }
    public VendorState withNewEvent(EventState event) {
        //this.noOfOrganizedEvents++;
        this.allEvents.add(event);
        return new VendorState(agency, percentage, totalSales, noOfOrganizedEvents + 1, allEvents, balance, linearId);
    }
    public VendorState updateBalanceAfterSell(double amount){
        return new VendorState(agency, percentage, totalSales + 1, noOfOrganizedEvents, allEvents, balance + amount, linearId);
    }
    public VendorState updateBalanceAfterRefund(double amount){
        return new VendorState(agency, percentage, totalSales - 1, noOfOrganizedEvents, allEvents, balance - amount, linearId);
    }
}

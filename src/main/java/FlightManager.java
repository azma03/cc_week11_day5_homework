import java.util.ArrayList;

public class FlightManager {

    public FlightManager() {
    }

    public int calculateTotalBaggageWeightPassengersHaveBooked(Flight flight) {
        int totalBaggageWeightBooked = 0;
        int weightPerBag = 20; //assumption that each passenger bag weighs the same

        ArrayList<Passenger> allPassengers =  flight.getPassengers();

        for (Passenger passenger: allPassengers){
            int baggagePerPassenger = weightPerBag * passenger.getNumberOfBags();
            totalBaggageWeightBooked += baggagePerPassenger;
        }

        return totalBaggageWeightBooked;
    }

    public int calculateRemainingReservedBaggageWeight(Flight flight) {

        double totalReservedBaggageWeightForAFlight = flight.getPlane().getTotalWeight() / 2;  //assumption that planes reserve half of their total weight for passenger bags

        double remainingReservedBaggageWeight = totalReservedBaggageWeightForAFlight - calculateTotalBaggageWeightPassengersHaveBooked(flight);

        return (int) remainingReservedBaggageWeight;

    }

    public int calculateBaggageReservedForEachPassenger(Flight flight) {
        /* Assumptions
        1- Planes reserve half of their total weight for passenger bags
        2- The weight of total baggage per person is a set value based on the plane weight and capacity
         */

        double totalReservedBaggageWeightForAFlight = flight.getPlane().getTotalWeight() / 2;

        int baggageReservedPerPassenger = (int) totalReservedBaggageWeightForAFlight / flight.getPlane().getCapacity();

        return baggageReservedPerPassenger;
    }
}

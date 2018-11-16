import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {
    
    FlightManager flightManager;
    Plane plane;
    Flight flight;
    SimpleDateFormat dateFormat;
    Date departureTime;
    Passenger passenger1, passenger2;

    @Before
    public void setUp() throws Exception {
        flightManager = new FlightManager();

        dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        departureTime = dateFormat.parse("2018/11/16 13:30");

        plane = new Plane(PlaneType.AIRBUS);
        flight = new Flight(plane, FlightNumbers.TJ101, Airports.DBX, Airports.GLA, departureTime);

        passenger1 = new Passenger("Asma", 2);
        passenger2 = new Passenger("Sarah", 1);


    }

    @Test
    public void canCalculateWeight__PassengersHaveBookedForAFlight() {
        flight.addPassengers(passenger1);
        flight.addPassengers(passenger2);
        assertEquals(60, flightManager.calculateTotalBaggageWeightPassengersHaveBooked(flight));
    }

    @Test
    public void canCalculateRemainingReservedBaggageWeigh() {
        flight.addPassengers(passenger1);
        assertEquals(40, flightManager.calculateRemainingReservedBaggageWeight(flight));
    }

    @Test
    public void canCalculateBaggageReservedForEachPassenger() {
        assertEquals(40, flightManager.calculateBaggageReservedForEachPassenger(flight));
    }
}

import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FlightTest {

    Plane plane;
    Flight flight;
    SimpleDateFormat dateFormat;
    Date departureTime;
    Passenger passenger1, passenger2, passenger3;

    @Before
    public void setUp() throws Exception {

        dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        departureTime = dateFormat.parse("2018/11/16 13:30");

        plane = new Plane(PlaneType.AIRBUS);
        flight = new Flight(plane, FlightNumbers.TJ101, Airports.DBX, Airports.GLA, departureTime);

        passenger1 = new Passenger("Asma", 2);
        passenger2 = new Passenger("Sarah", 1);
        passenger3 = new Passenger("Bob", 1);
    }

    @Test
    public void canGetPassengerCount() {
        assertEquals(0, flight.getPassengerCount());
    }

    @Test
    public void canGetPlane() {
        assertEquals(plane, flight.getPlane());
    }

    @Test
    public void canGetFlightNumber() {
        assertEquals(FlightNumbers.TJ101, flight.getFlightNumber());
    }

    @Test
    public void canGetDestination() {
        assertEquals(Airports.DBX, flight.getDestination());
    }

    @Test
    public void canGetDepartureAirport() {
        assertEquals(Airports.GLA, flight.getDepartureAirport());
    }

    @Test
    public void canGetDepartureTime() {
        assertEquals(departureTime, flight.getDepartureTime());
    }

    @Test
    public void canGetNumberOfAvailableSeats() {
        assertEquals(2, flight.getNumberOfAvailableSeats());
    }

    @Test
    public void canCheckIfPassengerHasCheckedInAlready() {
        flight.addPassengers(passenger1);
        assertEquals(true, flight.passengerCheckedIn(passenger1));
        assertEquals(false, flight.passengerCheckedIn(passenger2));
    }

    @Test
    public void canAddPassengers() {
        flight.addPassengers(passenger1);
        flight.addPassengers(passenger2);
        assertEquals(2, flight.getPassengerCount());
        assertEquals(flight, passenger1.getFlight());
        assertEquals(flight, passenger2.getFlight());
    }

    @Test
    public void DoNotAddPassenger__IfNoSeatsAvailable() {
        flight.addPassengers(passenger1);
        flight.addPassengers(passenger2);
        flight.addPassengers(passenger3); //should not add this passenger
        assertEquals(2, flight.getPassengerCount());
        assertEquals(flight, passenger1.getFlight());
        assertEquals(flight, passenger2.getFlight());
        assertEquals(null, passenger3.getFlight());
    }

    @Test
    public void canAssignAvailableSeatToPassenger() {
        flight.addPassengers(passenger1);
        assertNotEquals(0, passenger1.getSeatNumber());
        assertEquals(1, flight.getNumberOfAvailableSeats());

        flight.addPassengers(passenger2);
        assertNotEquals(0, passenger2.getSeatNumber());
        assertEquals(0, flight.getNumberOfAvailableSeats());

    }

    @Test
    public void cannotAddSamePassengerTwice() {
        flight.addPassengers(passenger1);
        flight.addPassengers(passenger1);
        assertEquals(1, flight.getPassengerCount());
    }
}

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    Passenger passenger;

    @Before
    public void setUp() throws Exception {
        passenger = new Passenger("Asma", 2);
    }

    @Test
    public void canGetName() {
        assertEquals("Asma", passenger.getName());
    }

    @Test
    public void canGetNumberOfBags() {
        assertEquals(2, passenger.getNumberOfBags());
    }

    @Test
    public void canGetSeatNumber() {
        assertEquals(0, passenger.getSeatNumber());
    }

    @Test
    public void canSetSeatNumber() {
        passenger.setSeatNumber(3);
        assertEquals(3, passenger.getSeatNumber());
    }
}

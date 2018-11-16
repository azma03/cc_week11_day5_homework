import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    Plane plane;

    @Before
    public void setUp() throws Exception {
        plane = new Plane(PlaneType.AIRBUS);
    }

    @Test
    public void canGetPlaneCapacity() {
        assertEquals(2, plane.getCapacity());
    }

    @Test
    public void canGetTotalWeight() {
        assertEquals(160, plane.getTotalWeight(), 0.01);
    }
}

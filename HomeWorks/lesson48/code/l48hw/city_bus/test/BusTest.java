package l48hw.city_bus.test;

import org.junit.jupiter.api.Test;
import l48hw.city_bus.CircularRoute;
import l48hw.city_bus.model.Bus;

import static org.junit.jupiter.api.Assertions.*;

public class BusTest {

    @Test
    public void testEquals() {
        Bus bus1 = new Bus("Scania", "1000AG", new CircularRoute(), 90);
        Bus bus2 = new Bus("Scania", "1000AG", new CircularRoute(), 90);
        Bus bus3 = new Bus("MAN", "2000AG", new CircularRoute(), 100);

        assertEquals(bus1, bus2);
        assertNotEquals(bus1, bus3);
    }

    @Test
    public void testAddStop() {
        CircularRoute route = new CircularRoute();
        route.addStop("A");
        route.addStop("B");
        route.addStop("C");

        assertEquals(3, route.getSize());
    }

    @Test
    public void testRemoveStop() {
        CircularRoute route = new CircularRoute();
        route.addStop("A");
        route.addStop("B");
        route.addStop("C");

        assertTrue(route.removeStop("B"));
        assertFalse(route.removeStop("D"));
        assertEquals(2, route.getSize());
    }

    @Test
    public void testModel() {
        Bus bus = new Bus("Scania", "1000AG", new CircularRoute(), 90);
        assertEquals("Scania", bus.getModel());

        bus.setModel("Volvo");
        assertEquals("Volvo", bus.getModel());
    }

    @Test
    public void testCapacity() {
        Bus bus = new Bus("Scania", "1000AG", new CircularRoute(), 90);
        assertEquals(90, bus.getCapacity());

        bus.setCapacity(95);
        assertEquals(95, bus.getCapacity());
    }

    @Test
    public void testWhenToGetOff() {
        CircularRoute route = new CircularRoute();
        route.addStop("A");
        route.addStop("B");
        route.addStop("C");
        route.addStop("D");
        route.addStop("E");

        assertEquals("Выходите на следующей остановке: C", route.whenToGetOff("B", "C"));
        assertEquals("Такой остановки нет в маршруте", route.whenToGetOff("D", "F"));
    }


    @Test
    public void testRegNumber() {
        Bus bus = new Bus("Scania", "1000AG", new CircularRoute(), 90);
        assertEquals("1000AG", bus.getRegNumber());

        bus.setRegNumber("2000BG");
        assertEquals("2000BG", bus.getRegNumber());
    }

    @Test
    public void testAddBusStop() {
        Bus bus = new Bus("Scania", "1000AG", new CircularRoute(), 90);
        CircularRoute route = bus.getRoute();

        assertEquals(0, route.getSize());

        bus.addBusStop("A");
        assertEquals(1, route.getSize());

        bus.addBusStop("B");
        assertEquals(2, route.getSize());
    }

    @Test
    public void testGetSize() {
        CircularRoute route = new CircularRoute();
        assertEquals(0, route.getSize());

        route.addStop("A");
        assertEquals(1, route.getSize());

        route.addStop("B");
        route.addStop("C");
        assertEquals(3, route.getSize());

        route.removeStop("B");
        assertEquals(2, route.getSize());
    }

}

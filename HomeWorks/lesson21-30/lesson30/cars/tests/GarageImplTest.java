package cars.tests;

import cars.dao.Garage;
import cars.dao.GarageImpl;
import cars.model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GarageImplTest {
    private Garage garage;
    private Car[] cars;

    @BeforeEach
    void setUp() {
        garage = new GarageImpl(6);
        cars = new Car[]{
                new Car("JKL654", "S-Class", "Mercedes-Benz", 4.0, "Black"),
                new Car("MNO321", "3 Series", "BMW", 3.0, "Blue"),
                new Car("GHI987", "Model S", "Tesla", 0.0, "Red"),
                new Car("ZYX456", "Aventador", "Lamborghini", 6.5, "Yellow"),
                new Car("QWE987", "911", "Porsche", 3.8, "White")
        };
    }

    @Test
    void addCarTest() {
        assertTrue(garage.addCar(cars[0]));
        assertTrue(garage.addCar(cars[1]));
        assertEquals(2,garage.size());
        assertFalse(garage.addCar(cars[0])); // Повторная попытка добавить тот же автомобиль
        assertFalse(garage.addCar(null)); // Попытка добавить null
        assertFalse(garage.addCar(new Car("JKL654", "S-Class", "Mercedes-Benz", 4.0, "Black"))); // Попытка добавить автомобиль с тем же регистрационным номером
    }

    @Test
    void removeCarTest() {
        for (Car car : cars) {
            garage.addCar(car);
        }

        assertEquals(cars[0], garage.removeCar("JKL654"));
        assertNull(garage.findCarByRegNumber("JKL654"));
        assertNull(garage.removeCar("JKL654"));

        assertEquals(cars[4], garage.removeCar("QWE987"));
        assertNull(garage.findCarByRegNumber("QWE987"));
    }

    @Test
    void findCarByRegNumberTest() {
        for (Car car : cars) {
            garage.addCar(car);
        }
        assertEquals(cars[0], garage.findCarByRegNumber("JKL654"));
        assertEquals(cars[2], garage.findCarByRegNumber("GHI987"));
        assertNull(garage.findCarByRegNumber("ABC123"));
    }

    @Test
    void findCarsByModelTest() {
        for (Car car : cars) {
            garage.addCar(car);
        }

        Car[] result = garage.findCarsByModel("S-Class");
        assertEquals(1, result.length);
        assertEquals(cars[0], result[0]);

        result = garage.findCarsByModel("3 Series");
        assertEquals(1, result.length);
        assertEquals(cars[1], result[0]);

        result = garage.findCarsByModel("Model S");
        assertEquals(1, result.length);
        assertEquals(cars[2], result[0]);

        result = garage.findCarsByModel("Camry");
        assertEquals(0, result.length);
    }

    @Test
    void findCarsByCompanyTest() {
        for (Car car : cars) {
            garage.addCar(car);
        }

        Car[] result = garage.findCarsByCompany("Mercedes-Benz");
        assertEquals(1, result.length);
        assertEquals(cars[0], result[0]);

        result = garage.findCarsByCompany("BMW");
        assertEquals(1, result.length);
        assertEquals(cars[1], result[0]);

        result = garage.findCarsByCompany("Porsche");
        assertEquals(1, result.length);
        assertEquals(cars[4], result[0]);

        result = garage.findCarsByCompany("Toyota");
        assertEquals(0, result.length);

    }

    @Test
    void findCarByEngineTest() {
        for (Car car : cars) {
            garage.addCar(car);
        }

        Car[] result = garage.findCarByEngine(3.0, 4.0);
        assertEquals(3, result.length);
        assertArrayEquals(new Car[]{cars[0], cars[1], cars[4]}, result);

        result = garage.findCarByEngine(0.0, 1.0);
        assertEquals(1, result.length);
        assertArrayEquals(new Car[]{cars[2]}, result);

        result = garage.findCarByEngine(6.5, 10.0);
        assertEquals(1, result.length);
        assertArrayEquals(new Car[]{cars[3]}, result);

        result = garage.findCarByEngine(2.0, 2.2);
        assertEquals(0, result.length);
        assertArrayEquals(new Car[]{}, result);
    }

    @Test
    void findCarByColorTest() {
        for (Car car : cars) {
            garage.addCar(car);
        }

        Car[] result = garage.findCarByColor("Black");
        assertEquals(1, result.length);
        assertEquals(cars[0], result[0]);

        result = garage.findCarByColor("Blue");
        assertEquals(1, result.length);
        assertEquals(cars[1], result[0]);

        result = garage.findCarByColor("Red");
        assertEquals(1, result.length);
        assertEquals(cars[2], result[0]);

        result = garage.findCarByColor("White");
        assertEquals(1, result.length);
        assertEquals(cars[4], result[0]);

        result = garage.findCarByColor("Green");
        assertEquals(0, result.length);

    }
}
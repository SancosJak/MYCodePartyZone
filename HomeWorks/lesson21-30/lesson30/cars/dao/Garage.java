package cars.dao;

import cars.model.Car;

public interface Garage {
    boolean addCar(Car car);
    Car removeCar(String regNumber);
    Car findCarByRegNumber(String regNumber);
    Car[] findCarsByModel(String model);
    Car[] findCarsByCompany(String company);
    Car[] findCarByEngine(double min, double max);
    Car[] findCarByColor(String color);
    int size();

}

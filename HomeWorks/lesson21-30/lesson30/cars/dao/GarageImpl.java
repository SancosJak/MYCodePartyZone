package cars.dao;

import cars.model.Car;

import java.util.Arrays;

public class GarageImpl implements Garage{

    private Car[] cars;
    private int size;

    public GarageImpl(int capacity){
        cars = new Car[capacity];
    }

    @Override
    public boolean addCar(Car car) {
        if (car == null || size == cars.length || findCarByRegNumber(car.getRegNumber()) != null){
            return false;
        }
        //cars[size++] = car; // посфиксная операции ++ увеличит size после присвоения
        cars[size] = car; //ставим в конец массива
        size++;
        return true;
    }

    @Override
    public Car removeCar(String regNumber) {
        for (int i = 0; i < size; i++) {
            if (regNumber.equals(cars[i].getRegNumber())){
                Car temp = cars[i];
                cars[i] = cars[--size]; // на место удаленного ставим последний
                cars[size] = null;
                return temp;
            }
        }
        return null;
    }

    @Override
    public Car findCarByRegNumber(String regNumber) {
        for (int i = 0; i < size; i++) {
            if (regNumber.equals(cars[i].getRegNumber())) {
                return cars[i];
            }
        }
        return null;
    }

    @Override
    public Car[] findCarsByModel(String model) {
        int count = 0;
        Car[] result = new Car[size];

        for (int i = 0; i < size; i++) {
            if (model.equals(cars[i].getModel())) {
                result[count++] = cars[i];
            }
        }
        return Arrays.copyOf(result, count);
    }

    @Override
    public Car[] findCarsByCompany(String company) {
        int count = 0;
        Car[] result = new Car[size];

        for (int i = 0; i < size; i++) {
            if (company.equals(cars[i].getCompany())) {
                result[count++] = cars[i];
            }
        }
        return Arrays.copyOf(result, count);
    }

    @Override
    public Car[] findCarByEngine(double min, double max) {
        int count = 0;
        Car[] result = new Car[size];

        for (int i = 0; i < size; i++) {
            double engineCapacity = cars[i].getEngine();
            if (engineCapacity >= min && engineCapacity <= max) {
                result[count++] = cars[i];
            }
        }
        return Arrays.copyOf(result, count);
    }

     @Override
    public Car[] findCarByColor(String color) {
        int count = 0;
        Car[] result = new Car[size];

        for (int i = 0; i < size; i++) {
            if (color.equals(cars[i].getColor())) {
                result[count++] = cars[i];
            }
        }
        return Arrays.copyOf(result, count);
    }

    @Override
    public int size() {
        return size;
    }
}

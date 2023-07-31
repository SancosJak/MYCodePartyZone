package carComp;
/*
Задание 1. Создайте несколько автомобилей в классе Car.
Отсортируйте и выведите на печать список автомобилей в порядке:
- модель
- компания
- объем двигателя

Задание 2. Добавьте в класс Car поле пробег автомобиля.
Добавьте значение этого поля в имеющиеся в гараже автомобили и выведите список,
отсортированный по пробегу в обратном порядке (авто с наибольшим пробегом сверху).
 */

import java.util.Objects;

public class Car  implements Comparable <Car>{

    private String model;
    private String company;
    private double engine;

    private int mileage; // New field for the mileage of the car

    public Car(String model, String company, double engine, int mileage) {
        this.model = model;
        this.company = company;
        this.engine = engine;
        this.mileage = mileage;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getEngine() {
        return engine;
    }

    public void setEngine(double engine) {
        this.engine = engine;
    }
    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", company='" + company + '\'' +
                ", engine=" + engine +
                ", mileage=" + mileage + // Include mileage in the output
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.engine, engine) == 0 && model.equals(car.model) && company.equals(car.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, company, engine);
    }

    @Override
    public int compareTo(Car o) {
        //sort by model
        //return this.model.compareTo(o.model); // a-z
        //return o.model.compareTo(this.model); // z-a

        //sort by company
        //return this.company.compareTo(o.company); // a-z
        //return o.company.compareTo(this.company); // z-a

        //sort by engine
        //return Double.compare(o.getEngine(),this.getEngine()); //down
        //return Double.compare(this.getEngine(),o.getEngine()); //up

        //sort by mileage
        return Double.compare(o.getMileage(),this.getMileage()); //down
        //return Double.compare(this.getMileage(),o.getMileage()); //up

    }
}

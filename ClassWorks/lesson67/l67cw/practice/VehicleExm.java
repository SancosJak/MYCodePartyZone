package practice;
//Создать класс `Vehicle` и на его основе классы `Car` и `Bicycle`. Добавить в них специфичные поля и методы.
class Vehicle {
    private String name;
    private int wheels;

    public Vehicle(String name, int wheels) {
        this.name = name;
        this.wheels = wheels;
    }

    public String getName() {
        return name;
    }

    public int getWheels() {
        return wheels;
    }

    public void start() {
        System.out.println(name + " is starting.");
    }

    public void stop() {
        System.out.println(name + " is stopping.");
    }
}

class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String name, int numberOfDoors) {
        super(name, 4);
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void honk() {
        System.out.println(getName() + " is honking the horn.");
    }
}

class Bicycle extends Vehicle {
    private int numberOfGears;

    public Bicycle(String name, int numberOfGears) {
        super(name, 2); // Bicycles typically have 2 wheels
        this.numberOfGears = numberOfGears;
    }

    public int getNumberOfGears() {
        return numberOfGears;
    }

    public void ringBell() {
        System.out.println(getName() + " is ringing the bell.");
    }
}

public class VehicleExm {
    public static void main(String[] args) {
        Car car = new Car("Toyota", 4);
        Bicycle bicycle = new Bicycle("Mountain Bike", 21);

        car.start();
        car.honk();
        car.stop();

        bicycle.start();
        bicycle.ringBell();
        bicycle.stop();
    }
}
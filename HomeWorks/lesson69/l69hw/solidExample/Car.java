package solidExample;

import java.util.ArrayList;
import java.util.List;

// Реализация интерфейса CarSaver
class DatabaseCarSaver implements CarSaver {
    private List<Car> database;

    public DatabaseCarSaver(List<Car> database) {
        this.database = database;
    }

    public void save(Car car) {
        database.add(car);
        System.out.println("Car saved to database.");
    }
}

// Класс Car теперь следует принципам SOLID
public class Car {
    private String model;
    private String brand;
    private int year;
    private boolean engineOn;

    public Car(String model, String brand, int year) {
        this.model = model;
        this.brand = brand;
        this.year = year;
        this.engineOn = false;
    }

    // Методы, связанные только с автомобилем
    public void startEngine() {
        engineOn = true;
        System.out.println("Engine is started.");
    }

    public void stopEngine() {
        engineOn = false;
        System.out.println("Engine is stopped.");
    }

    public void showCarDetails() {
        System.out.println("Brand: " + brand + ", Model: " + model + ", Year: " + year);
        if (engineOn) {
            System.out.println("Engine is on");
        } else {
            System.out.println("Engine is off");
        }
    }
    // Использование
    public static void main(String[]args){
        List<Car> carDatabase=new ArrayList<>();
        CarSaver carSaver=new DatabaseCarSaver(carDatabase);

        Car myCar=new Car("Model S","Tesla",2020);
        myCar.startEngine();
        myCar.showCarDetails();

        // Сохраняем автомобиль в базу данных
        carSaver.save(myCar);
    }
}
package notSolidExample;

import java.util.List;

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

    public void startEngine() {
        engineOn = true;
        System.out.println("Engine is started.");
    }

    public void stopEngine() {
        engineOn = false;
        System.out.println("Engine is stopped.");
    }

    // Этот метод делает слишком много. Он изменяет состояние и занимается выводом.
    public void showCarDetails() {
        System.out.println("Brand: " + brand + ", Model: " + model + ", Year: " + year);
        if (engineOn) {
            System.out.println("Engine is on");
        } else {
            System.out.println("Engine is off");
        }
    }

    // Метод для добавления автомобиля в базу данных (нарушает SRP и DIP)
    public void saveCarToDatabase(List<Car> database) {
        database.add(this);
        System.out.println("Car saved to database.");
    }
}
/*
Single Responsibility Principle (SRP): Класс Car имеет больше одной ответственности. Он управляет данными автомобиля и сохраняет их в базу данных.

Open/Closed Principle (OCP): Если нужно изменить способ сохранения данных, класс Car потребуется модифицировать.

Liskov Substitution Principle (LSP): В этом простом примере LSP не очень применим, но можно представить, что если мы расширяем этот класс, проблемы могут возникнуть.

Interface Segregation Principle (ISP): Класс Car имеет метод saveCarToDatabase(), который не связан с основной ответственностью класса.

Dependency Inversion Principle (DIP): Класс Car зависит от конкретного списка, что делает его зависимым от низкоуровневой детали.
 */
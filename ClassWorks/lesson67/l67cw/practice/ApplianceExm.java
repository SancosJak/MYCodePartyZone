package practice;
//Создать абстрактный класс Appliance с методами turnOn() и turnOff().
//На его основе реализовать классы WashingMachine и Refrigerator.

abstract class Appliance {
    public abstract void turnOn();
    public abstract void turnOff();
}

class WashingMachine extends Appliance {
    @Override
    public void turnOn() {
        System.out.println("Washing machine is turned on.");
    }

    @Override
    public void turnOff() {
        System.out.println("Washing machine is turned off.");
    }

}

class Refrigerator extends Appliance {
    @Override
    public void turnOn() {
        System.out.println("Refrigerator is turned on.");
    }

    @Override
    public void turnOff() {
        System.out.println("Refrigerator is turned off.");
    }

}

public class ApplianceExm {
    public static void main(String[] args) {
        Appliance washingMachine = new WashingMachine();
        Appliance refrigerator = new Refrigerator();

        washingMachine.turnOn();
        washingMachine.turnOff();

        refrigerator.turnOn();
        refrigerator.turnOff();
    }
}
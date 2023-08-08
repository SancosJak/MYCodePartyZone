package l25hw1.busAppl;
/*
Создать класс Bus (автобус) - с полями номер маршрута, вместимость, скорость на маршруте, длина маршрута.
Реализовать методы go, stop, speedUp, speedDown
 */
import l25hw1.model.Bus;

public class BusAppl {
    public static void main(String[] args) {

        Bus bus1 = new Bus(261, 50, 50, 25);
        bus1.go();
        bus1.speedUp(20);
        bus1.speedDown(10);
        bus1.stop();
        System.out.println();

        Bus bus2 = new Bus(188, 40, 70, 40);
        bus2.go();
        bus2.speedUp(15);
        bus2.speedDown(20);
        bus2.stop();
        System.out.println();

        Bus bus3 = new Bus(217, 35, 70, 50);
        bus3.go();
        bus3.speedUp(25);
        bus3.speedDown(15);
        bus3.stop();
    }
}

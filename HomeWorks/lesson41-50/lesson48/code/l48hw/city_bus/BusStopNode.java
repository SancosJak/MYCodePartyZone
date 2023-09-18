package l48hw.city_bus;

public class BusStopNode {
    String stopName;
    BusStopNode next;
    BusStopNode prev; // Добавляем ссылку на предыдущую остановку

    public BusStopNode(String stopName) {
        this.stopName = stopName;
        this.next = null;
    }
}

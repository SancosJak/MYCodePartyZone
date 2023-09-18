package l48hw.city_bus;
// Попробовать реализовать двусвязный список (предыдущая остановка и следующая)
public class CircularRoute {
    private BusStopNode head;
    private int size;

    public CircularRoute() {
        head = null;
        size = 0;
    }
// было - односвязный список
//    public void addStop(String stopName) {
//        BusStopNode newNode = new BusStopNode(stopName);
//        if (head == null) {
//            head = newNode;
//            head.next = head; // кольцевая связь
//        } else {
//            BusStopNode temp = head;
//            while (temp.next != head) {
//                temp = temp.next;
//            }
//            temp.next = newNode;
//            newNode.next = head; // кольцевая связь
//        }
//        size++;
//    }

    // стало - двусвязный список
    public void addStop(String stopName) {
        BusStopNode newNode = new BusStopNode(stopName);
        if (head == null) {
            head = newNode;
            head.next = newNode; // В начале, новая остановка ссылается на саму себя как следующую и предыдущую
            head.prev = newNode;
        } else {
            BusStopNode last = head.prev; // Получаем последнюю остановку
            last.next = newNode; // Последняя остановка ссылается на новую как следующую
            newNode.prev = last; // Новая остановка ссылается на последнюю как предыдущую
            newNode.next = head; // Новая остановка ссылается на голову как следующую
            head.prev = newNode; // Голова теперь ссылается на новую остановку как предыдущую
        }
        size++;
    }


    public boolean removeStop(String stopName) {
        if (head == null) return false;

        BusStopNode current = head;
        BusStopNode prev = null;
        do {
            if (current.stopName.equals(stopName)) {
                if (prev != null) {
                    prev.next = current.next;
                    if (current == head) {
                        head = prev.next;
                    }
                } else {
                    // Если удаляем голову
                    BusStopNode temp = head;
                    while (temp.next != head) {
                        temp = temp.next;
                    }
                    head = head.next;
                    temp.next = head;
                }
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        return false;
    }

    public String whenToGetOff(String start, String end) {
        if (head == null) return "Маршрут пуст";

        BusStopNode temp = head;
        boolean foundStart = false;
        do {
            if (temp.stopName.equals(start)) foundStart = true;
            if (foundStart && temp.stopName.equals(end)) return "Выходите на следующей остановке: " + end;

            temp = temp.next;
        } while (temp != head);

        return "Такой остановки нет в маршруте";
    }

    public int getSize() {
        return size;
    }
}
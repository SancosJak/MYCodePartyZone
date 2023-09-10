package practice;

import practice47.city_bus.BusStopNode;

public class TeachersSandbox2 {
    // разбор LinkedList
    public static void main(String[] args) {
        BusStopNode berlin = new BusStopNode("Berlin");
        BusStopNode munich = new BusStopNode("Munich");
        BusStopNode nuremberg = new BusStopNode("Nuremberg");
        BusStopNode stuttgart = new BusStopNode("Stuttgart");
        BusStopNode koeln = new BusStopNode("Koeln");
        berlin.setNext(munich);
        berlin.getNext();
        berlin.setNext(nuremberg); // berlin -> след остановка Nuremberg
        nuremberg.setNext(munich); // nuremberg -> след остановка Munich
        munich.setNext(stuttgart); // след остановка Stuttgart
        stuttgart.setNext(koeln); // след остановка Koln
        BusStopNode node = berlin;

        while (node != null) {
            System.out.println(node.getStopName());
            node = node.getNext();
        }
    }

    // пример класса не обязательный к применению
    static class Node {
        Object data; // данные
        Node next; // ссылка на следующую ноду
    }

    // [0][1][2][3][4]

    // LinkedList.size() -> количество нод в цепи
    //index:         0                  1                  2                    3
    //       <- [Ul Pushkina] <-> [Prospekt Mira] <-> [Ul Lenina]    <->     [Ul N-ya] - >
    //                |                 |                  |                    |
    //            посуда            одежда              книги                техника
    //              head                                                      tail
    //      (начало или голова)                                          (хвост или конец)
}

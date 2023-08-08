package kniga.controller;
import kniga.model.Kniga;

public class BookAppl {
    public static void main(String[] args) {

        // создаем объектные переменные book1, book2, book3
        Kniga book1 = new Kniga("Heart of Dragon", "Kirill Klevanski", 2016, 1000000000L);
        Kniga book2 = new Kniga("Code Da Vinci", "Den Brown", 2003, 1000000001L);
        Kniga book3 = new Kniga("Jack London", "White...", 1900, 1000000201L);

        book1.display();
        book2.display();
        book3.display();

    }
}
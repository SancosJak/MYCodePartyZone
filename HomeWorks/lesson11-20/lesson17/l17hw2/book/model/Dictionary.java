package l17hw2.book.model;
/*
Создайте класс Dictionary, который расширяет класс Book.
Предложите для него набор полей и переопределите метод display.
В классе BookAppl в методе main создайте несколько словарей и выведите информацию о них в консоль.
 */
public class Dictionary extends Book {
    public String language;
    public int pages;

    public Dictionary(String title, String author, int yearOfPublishing, String language, int pages) {
        super(title, author, yearOfPublishing);
        this.language = language;
        this.pages = pages;
    }

    public void display() {
        super.display();
        System.out.println("Language: " + language);
        System.out.println("Pages: " + pages);
        System.out.println();
    }
}
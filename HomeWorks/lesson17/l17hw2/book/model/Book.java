package l17hw2.book.model;
/*
Создать класс Book в пакете xxx.book.model. В этом классе определить поля: private long isbn;
private String title; private String author; private int yearOfPublishing;
Создать конструкторы для иницализации всех полей, и конструктор для инициализации полей
при отсутствии автора. Остальные конструкторы на Ваше усмотрение.
Создать геттеры и сеттеры, исходя из логики и необходимости.
Создать метод public void display() для печати в консоль информации о книге.
 */
public class Book {
    private  long isbn;
    private  String title;
    private  String author;
    private  int yearOfPublishing;

    public Book(long isbn, String title, String author, int yearOfPublishing) {
        this.isbn = isbn; //International Standard Book Number
        this.title = title;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
    }
    // without author
    public Book(long isbn, String title, int yearOfPublishing) {
        this.isbn = isbn;
        this.title = title;
        this.yearOfPublishing = yearOfPublishing;
    }
    // without isbn
    public Book(String title, String author, int yearOfPublishing) {
        this.title = title;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
    }

    public long getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }
    public void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year of Publishing: " + yearOfPublishing);
        System.out.println("ISBN: " + isbn);
        System.out.println();
    }
}

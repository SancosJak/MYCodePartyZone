package book.bookAppl;
import book.model.Book;

public class BookAppl {
    public static void main(String[] args) {

        Book book1 = new Book(9780552149518L, "The Da Vinci Code", "Dan Brown", 2003);
        Book book2 = new Book(9781853260339L, "Sherlock Holmes: The Complete Novels and Stories", "Arthur Conan Doyle", 1887);
        Book book3 = new Book(9780553103540L, "A Game of Thrones", "George R.R. Martin", 1996);
        Book book4 = new Book(9780545010221L, "Harry Potter and the Philosopher's Stone",1997); //without author
        Book book5 = new Book("The Picture of Dorian Gray", "Oscar Wilde", 1890); // without isbn

        book1.display();
        book2.display();
        book3.display();
        book4.display();
        book5.display();
    }
}

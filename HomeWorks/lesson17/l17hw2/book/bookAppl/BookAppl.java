package l17hw2.book.bookAppl;
import l17hw2.book.model.Book;
import l17hw2.book.model.Dictionary;

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

        Dictionary dict1 = new Dictionary("German-English Dictionary", "Kleinmann Walter", 1995, "English, German", 1244);
        dict1.display();
        System.out.println("---------");
        Dictionary dict2 = new Dictionary("American Dictionary of the English Language", "Noah Webster", 1839, "American, English", 456);
        dict2.display();
    }
}

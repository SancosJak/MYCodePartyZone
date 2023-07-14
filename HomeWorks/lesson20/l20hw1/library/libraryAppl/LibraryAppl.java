package library.libraryAppl;
/*
реализовать методы поиска книг в библиотеке
- по автору
- по названию книги
 */
import library.model.Book;
import library.model.Library;
import java.util.Scanner;

public class LibraryAppl {
    public static void main(String[] args) {
        Library library = new Library(10);

        library.addBook(new Book("The Da Vinci Code", "Dan Brown"));
        library.addBook(new Book("A Game of Thrones", "George R.R. Martin"));
        library.addBook(new Book("Harry Potter and the Sorcerer’s Stone", "J.K. Rowling"));
        library.addBook(new Book("The Picture of Dorian Gray", "Oscar Wilde"));
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
        library.addBook(new Book("Harry Potter and the Chamber of Secrets", "J.K. Rowling"));
        library.addBook(new Book("Harry Potter and the Order of the Phoenix", "J.K. Rowling"));
        library.addBook(new Book("A Game of Thrones : Fire & Blood", "George R.R. Martin"));


        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Select your search criteria:");
            System.out.println("1. Search by author (e.q. Dan Brown or J.K. Rowling) ");
            System.out.println("2. Search by title (e.q. Harry Potter or A Game of Thrones)");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Enter the author: ");
                    String author = scanner.nextLine();
                    Book[] booksByAuthor = library.searchByAuthor(author);
                    System.out.println("Found books by the author " + author + ":");
                    printBooks(booksByAuthor);
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.print("Enter a title: ");
                    String title = scanner.nextLine();
                    Book[] booksByTitle = library.searchByTitle(title);
                    System.out.println("Found books with the title " + title + ":");
                    printBooks(booksByTitle);
                    break;
                case 0:
                    System.out.println("Bye - bye");
                    break;
                default:
                    System.out.println("Wrong choice. Try again.");
                    break;
            }
            System.out.println();
        } while (choice != 0);
    }

    public static void printBooks(Book[] books) {
        if (books.length == 0) {
            System.out.println("No Books Found.");
        } else {
            for (Book book : books) {
                if (book != null) {
                    System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor());
                }
            }
        }
    }
}

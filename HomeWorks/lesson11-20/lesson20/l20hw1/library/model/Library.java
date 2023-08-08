package library.model;

public class Library {
    private Book[] books;
    private int count;

    public Library(int capacity) {
        books = new Book[capacity];
        count = 0;
    }

    public void addBook(Book book) {
        if (count < books.length) {
            books[count] = book;
            count++;
        }
    }

    public Book[] searchByAuthor(String author) {
        Book[] foundBooks = new Book[count];
        int foundCount = 0;

        for (int i = 0; i < count; i++) {
            if (books[i].getAuthor().equalsIgnoreCase(author)) {
                foundBooks[foundCount] = books[i];
                foundCount++;
            }
        }
        //equalsIgnoreCase - сравнения строк без учета регистра символов
        return foundBooks;
    }

    public Book[] searchByTitle(String title) {
        Book[] foundBooks = new Book[count];
        int foundCount = 0;

        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().toLowerCase().startsWith(title.toLowerCase())) {
                foundBooks[foundCount] = books[i];
                foundCount++;
            }
        }
        // startsWith - чтобы проверить, начинается ли название книги с указанной строки title

        return foundBooks;
    }
}
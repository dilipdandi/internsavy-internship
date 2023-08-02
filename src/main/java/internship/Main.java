package internship;

import java.util.HashMap;
import java.util.Map;

class Book {
    public int id;
    public String title;
    public String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
}

class BookCRUD {
    private Map<Integer, Book> books;

    public BookCRUD() {
        books = new HashMap<>();
    }

    public void createBook(int id, String title, String author) {
        Book book = new Book(id, title, author);
        books.put(id, book);
    }

    public Book readBook(int id) {
        return books.get(id);
    }

    public void updateBook(int id, String newTitle, String newAuthor) {
        Book book = books.get(id);
        if (book != null) {
            book.title = newTitle;
            book.author = newAuthor;
        }
    }

    public void deleteBook(int id) {
        books.remove(id);
    }
}

public class Main {
    public static void main(String[] args) {
        BookCRUD bookCRUD = new BookCRUD();

        bookCRUD.createBook(1, "Head First Java", "Kathy Sierra");
        bookCRUD.createBook(2, "Programming Python", "Mark Lutz");

        Book book1 = bookCRUD.readBook(1);
        if (book1 != null) {
            System.out.println("Book ID: " + book1.id);
            System.out.println("Title: " + book1.title);
            System.out.println("Author: " + book1.author);
        }

        bookCRUD.updateBook(1, "Head First Java - Revised Edition", "Kathy Sierra");

        Book updatedBook = bookCRUD.readBook(1);
        if (updatedBook != null) {
            System.out.println("Updated Title: " + updatedBook.title);
            System.out.println("Updated Author: " + updatedBook.author);
        }

        bookCRUD.deleteBook(2);
        Book deletedBook = bookCRUD.readBook(2);
        if (deletedBook == null) {
            System.out.println("Book with ID 2 has been deleted.");
        }
    }
}

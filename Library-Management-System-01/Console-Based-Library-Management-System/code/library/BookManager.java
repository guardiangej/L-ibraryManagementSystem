package library;

import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private List<Book> availableBooks;
    private List<Book> borrowedBooks;

    public BookManager(List<Book> availableBooks) {
        this.availableBooks = availableBooks;
        this.borrowedBooks = new ArrayList<>();
    }

    public boolean borrowBook(String title) {
        for (Book book : availableBooks) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                availableBooks.remove(book);
                borrowedBooks.add(book);
                book.setAvailable(false);
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(String title) {
        for (Book book : borrowedBooks) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                borrowedBooks.remove(book);
                availableBooks.add(book);
                book.setAvailable(true);
                return true;
            }
        }
        return false;
    }

    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : availableBooks) {
            System.out.println(book.getTitle());
        }
    }

    public void displayBorrowedBooks() {
        System.out.println("Borrowed Books:");
        for (Book book : borrowedBooks) {
            System.out.println(book.getTitle());
        }
    }
}

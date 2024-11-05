package library;

import java.util.ArrayList;

public class LibrarySystem {
    private ArrayList<Book> books;

    public LibrarySystem() {
        books = new ArrayList<>();
    }

    // Add a book to the library
    public void addBook(String title, String author, String isbn) {
        books.add(new Book(title, author, isbn));
    }

    // Search for a book by title
    public void searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.displayBookInfo();
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Check out a book
    public void checkOutBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (!book.isCheckedOut()) {
                    book.checkOut();
                    System.out.println("You have successfully checked out: " + book.getTitle());
                    return;
                } else {
                    System.out.println("This book is already checked out.");
                    return;
                }
            }
        }
        System.out.println("Book not found.");
    }

    // Return a book
    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isCheckedOut()) {
                    book.returnBook();
                    System.out.println("You have successfully returned: " + book.getTitle());
                    return;
                } else {
                    System.out.println("This book wasn't checked out.");
                    return;
                }
            }
        }
        System.out.println("Book not found.");
    }

    // Display all books
    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book book : books) {
                book.displayBookInfo();
            }
        }
    }
}

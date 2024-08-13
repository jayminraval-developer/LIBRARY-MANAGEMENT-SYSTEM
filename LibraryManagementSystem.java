package CognoRiseInfotech;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {

    // Book class
    static class Book {
        private String title;
        private String author;
        private boolean isAvailable;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
            this.isAvailable = true;
        }

        public String getTitle() { return title; }
        public String getAuthor() { return author; }
        public boolean isAvailable() { return isAvailable; }
        public void setAvailable(boolean available) { this.isAvailable = available; }

        @Override
        public String toString() {
            return title + " by " + author + " [" + (isAvailable ? "Available" : "Checked Out") + "]";
        }
    }

    // LibraryCatalog class
    static class LibraryCatalog {
        private List<Book> books;

        public LibraryCatalog() {
            books = new ArrayList<>();
        }

        public void addBook(Book book) {
            books.add(book);
        }

        public void searchByTitle(String title) {
            for (Book book : books) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    System.out.println(book);
                    return;
                }
            }
            System.out.println("Book not found.");
        }

        public void searchByAuthor(String author) {
            for (Book book : books) {
                if (book.getAuthor().equalsIgnoreCase(author)) {
                    System.out.println(book);
                    return;
                }
            }
            System.out.println("No books found by this author.");
        }

        public void checkOutBook(String title) {
            for (Book book : books) {
                if (book.getTitle().equalsIgnoreCase(title) && book.isAvailable()) {
                    book.setAvailable(false);
                    System.out.println("Checked out: " + book);
                    return;
                }
            }
            System.out.println("Book not available or not found.");
        }

        public void returnBook(String title) {
            for (Book book : books) {
                if (book.getTitle().equalsIgnoreCase(title) && !book.isAvailable()) {
                    book.setAvailable(true);
                    System.out.println("Returned: " + book);
                    return;
                }
            }
            System.out.println("Book not found or already available.");
        }

        public void displayAllBooks() {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    // Main class
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryCatalog catalog = new LibraryCatalog();

        // Adding books to the catalog
        catalog.addBook(new Book(" C", "Dennis Ritchie"));
        catalog.addBook(new Book(" C++", " Bjarne Stroustrup"));
        catalog.addBook(new Book("Java", "Sun Microsystems"));
        catalog.addBook((new Book("Python", "Guido van Rossum")));
        catalog.addBook((new Book("PHP", "Rasmus Lerdorf")));
        catalog.addBook((new Book("JavaScript", " Brendan Eich")));
        catalog.addBook((new Book("Ruby", "Yukihiro Matsumoto")));

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Display all books");
            System.out.println("2. Search by title");
            System.out.println("3. Search by author");
            System.out.println("4. Check out a book");
            System.out.println("5. Return a book");
            System.out.println("6. Exit");

            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    catalog.displayAllBooks();
                    break;
                case 2:
                    System.out.print("Enter title to search: ");
                    String title = scanner.nextLine();
                    catalog.searchByTitle(title);
                    break;
                case 3:
                    System.out.print("Enter author to search: ");
                    String author = scanner.nextLine();
                    catalog.searchByAuthor(author);
                    break;
                case 4:
                    System.out.print("Enter title of the book to check out: ");
                    String checkOutTitle = scanner.nextLine();
                    catalog.checkOutBook(checkOutTitle);
                    break;
                case 5:
                    System.out.print("Enter title of the book to return: ");
                    String returnTitle = scanner.nextLine();
                    catalog.returnBook(returnTitle);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

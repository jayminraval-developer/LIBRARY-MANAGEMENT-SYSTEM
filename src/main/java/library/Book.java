package library;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isCheckedOut;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isCheckedOut = false;  // Books are available by default
    }

    // Getter and Setter methods
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void checkOut() {
        this.isCheckedOut = true;
    }

    public void returnBook() {
        this.isCheckedOut = false;
    }

    // Method to display book details
    public void displayBookInfo() {
        String status = isCheckedOut ? "Checked Out" : "Available";
        System.out.println("Title: " + title + ", Author: " + author + ", ISBN: " + isbn + ", Status: " + status);
    }
}

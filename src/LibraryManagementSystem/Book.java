package LibraryManagementSystem;

public class Book {

    private String title;
    private String author;
    private boolean isAvailable; // This keeps track if the book is available or not
    private String genre;
    private int publishYear;
    private int isbn; // Uniqe


    // Constructor to initialize a new book with given details and set it as available initially
    public Book(String title, String author, int isbn, String genre, int publishYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.genre = genre;
        this.publishYear = publishYear;
        this.isAvailable = true; // The book is available at the beginning
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getIsbn() {
        return isbn;
    }

    public String getGenre() {
        return genre;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // This method lets the user borrow a book by ISBN.
    // It finds the book and calls the book's borrow() method.
    // It shows messages depending on success or failure.
    public boolean borrow() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        } else {
            return false;
        }
    }

    // This method tries to return the book.
    // It changes the book status if it is not available.
    // Returns true if successful, false if the book is already available.
    public boolean returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            return true; // Successful return
        } else {
            return false; // The book is already available, cannot be returned again
        }
    }

    @Override
    public String toString() {
        return "Title: " + title + "\n" +
                "Author: " + author + "\n" +
                "ISBN: " + isbn + "\n" +
                "Status: " + (isAvailable ? "Available" : "Not Available") + "\n" +
                "Genre: " + genre + "\n" +
                "Publish Year: " + publishYear + "\n" +
                "------------------------------";
    }
}

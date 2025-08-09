package LibraryManagerSystem;

public class Book {

    private static int idCounter = 1; // Counter for the unique ID of each book
    private String name;
    private String author;
    private boolean isAvailable; //Whether book is available or not
    private String genre;
    private int publishYear;
    private int isbn; // Unique book identifier used for borrowing and returning books


    public Book(String name, String author, int isbn, String genre, int publishYear) {

        this.name = name;
        this.author = author;
        this.isbn = isbn;
        this.genre = genre;
        this.publishYear = publishYear;
        this.isAvailable = true; // By default, the book is assumed not to be borrowed initially
    }

    // Since the variables are private, getter and setter methods are provided for external access
    public String getName() {
        return name;
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

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Title: " + name + "\n" +
                "Author: " + author + "\n" +
                "ISBN: " + isbn + "\n" +
                "Status: " + (isAvailable ? "Available" : "Not Available") + "\n" +
                "Genre: " + genre + "\n" +
                "Publish Year: " + publishYear + "\n" +
                "------------------------------";
    }

}
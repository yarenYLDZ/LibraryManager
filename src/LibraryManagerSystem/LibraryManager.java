package LibraryManagerSystem;

import java.util.ArrayList;
import java.util.List;


public class LibraryManager {

    private final List<Book> books; // List to store all books in the library system


    public LibraryManager(){
        // Initialize the list to hold books when the library manager is created
        books = new ArrayList<>();

    }

    // This method adds a new book to the library collection.
    // This method checks if a book with the same ISBN already exists to avoid duplicates.
    // If a duplicate is found, this method prints an error and does not add the book.
    public void addBook(Book book){
        // Check if a book with the same ISBN already exists
        for (Book b : books) {
            if (b.getIsbn() == book.getIsbn()) {
                System.out.println("ERROR: A book with ISBN " + book.getIsbn() + " already exists in the library.");
                return; // Exit without adding the duplicate book
            }
        }
        books.add(book);
        System.out.println("PROCESS RESULT: Book added successfully");
    }


    // Method to display all books in the library
    // If no books exist, it informs the user
    // Otherwise, it prints detailed information of each book
    public void listBooks(){
        if(books.isEmpty()){
            System.out.println("There are no books to list in the library.");
        } else {
            System.out.println("----BOOKS IN THE LIBRARY----");
            for (Book book: books){
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("ISBN: " + book.getIsbn());
                System.out.println("Status: " + (book.isAvailable() ? "Available" : "Not Available"));
                System.out.println("Genre: " + book.getGenre());
                System.out.println("Publish Year: " + book.getPublishYear());
                System.out.println("----------------------------");
            }
        }
    }


    // Search for books containing the given title (case insensitive)
    // Returns a list of books that match the search query
    public List<Book> searchBookByTitle(String title){
        List<Book> foundBooks=new ArrayList<>();
        for(Book book:books){
            if(book.getTitle().toLowerCase().contains(title.toLowerCase())){
                foundBooks.add(book);
            }

        }
        return foundBooks;
    }


    // Attempts to borrow a book by ISBN
    // If found and available, marks as borrowed and prints success message
    // Otherwise, informs if book is already borrowed or not found
    public void borrowBook(int isbn) {
        for (Book book : books) {
            if (book.getIsbn() == isbn) {
                if (book.borrow()) {
                    System.out.println("Book borrowed. \n" + book);
                } else {
                    System.out.println("This book has already been borrowed. \n" + book);
                }
                return;
            }
        }
        System.out.println("No book found matching the ISBN number.\n");
    }


    // Attempts to return a book by ISBN
    // If found and currently borrowed, marks as available and prints success message
    // Otherwise, informs if book is already returned or not found
    public void returnBook(int isbn) {
        for (Book book : books) {
            if (book.getIsbn() == isbn) {
                if (book.returnBook()) {
                    System.out.println("Book returned\n" + book);
                } else {
                    System.out.println("This book has already been returned\n" + book);
                }
                return;
            }
        }
        System.out.println("No book found matching the ISBN number.");
    }

}

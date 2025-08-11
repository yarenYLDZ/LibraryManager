package LibraryManagementSystem;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class LibraryManager {

    // Map to store books with ISBN as the unique key
    private final Map<Integer, Book> books; // ISBN -> Book

    // Constructor initializes the book collection
    public LibraryManager() {
        books = new HashMap<>();
    }

    /**
     * Adds a new book to the library collection.
     * Checks if a book with the same ISBN already exists to prevent duplicates.
     * If the ISBN exists, it prints an error message and does not add the book.
     * Otherwise, the book is added successfully.
     */
    public void addBook(Book book) {
        if (books.containsKey(book.getIsbn())) {
            System.out.println("ERROR: A book with ISBN " + book.getIsbn() + " already exists in the library.");
            return;
        }
        books.put(book.getIsbn(), book);
        System.out.println("PROCESS RESULT: Book added successfully");
    }

    /**
     * Lists all the books currently available in the library.
     * If no books are present, it informs the user accordingly.
     * Each book's details are printed using the overridden toString() method of Book.
     */
    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("There are no books to list in the library.");
        } else {
            System.out.println("----BOOKS IN THE LIBRARY----");
            for (Book book : books.values()) {
                System.out.println(book);
            }
        }
    }

    /**
     * Searches for books whose titles contain the given search string.
     * The search is case-insensitive.
     * Returns a list of all matching books.
     *
     * @param title The search keyword for the book title.
     * @return List of books matching the search criteria.
     */
    public List<Book> searchBookByTitle(String title) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    /**
     * Attempts to borrow a book identified by its ISBN.
     * Checks if the book exists; if not, informs the user.
     * If the book is already borrowed, informs the user it cannot be borrowed again.
     * If the book is available, marks it as borrowed and confirms success.
     *
     * @param isbn The ISBN number of the book to borrow.
     */
    public void borrowBook(int isbn) {
        Book book = books.get(isbn);
        if (book == null) {
            System.out.println("No book found matching the ISBN number.\n");
            return;
        }
        if (book.borrow()) {
            System.out.println("Book borrowed. \n" + book);
        } else {
            System.out.println("This book has already been borrowed. \n" + book);
        }
    }

    /**
     * Attempts to return a book identified by its ISBN.
     * Checks if the book exists; if not, informs the user.
     * If the book was not borrowed, informs the user it cannot be returned.
     * If the book was borrowed, marks it as returned and confirms success.
     *
     * @param isbn The ISBN number of the book to return.
     */
    public void returnBook(int isbn) {
        Book book = books.get(isbn);
        if (book == null) {
            System.out.println("No book found matching the ISBN number.");
            return;
        }
        if (book.returnBook()) {
            System.out.println("Book returned\n" + book);
        } else {
            System.out.println("This book has already been returned\n" + book);
        }
    }
}

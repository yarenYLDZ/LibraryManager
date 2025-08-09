package LibraryManagerSystem;

import java.util.ArrayList;
import java.util.List;


public class LibraryManager {

    private final List<Book> books; // List to store books

    public LibraryManager(){
        books = new ArrayList<>();

    }

    // Method to add a book
    public void addBook(Book book){
        books.add(book);
        System.out.println("PROCESS RESULT: Book added successfully");

    }

    // Method to list books
    public void listBooks(){
        if(books.isEmpty()){
            System.out.println("There are no books to list in the library.");
        } else {
            System.out.println("----BOOKS IN THE LIBRARY----");
            for (Book book: books){
                System.out.println("Title: " + book.getName());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("ISBN: " + book.getIsbn());
                System.out.println("Status: " + (book.isAvailable() ? "Available" : "Not Available"));
                System.out.println("Genre: " + book.getGenre());
                System.out.println("Publish Year: " + book.getPublishYear());
                System.out.println("----------------------------");
            }
        }
    }


    // Method to search books by their titles
    public List<Book> searchBookByTitle(String title){
        List<Book> foundBooks=new ArrayList<>();
        for(Book book:books){
            if(book.getName().toLowerCase().contains(title.toLowerCase())){
                foundBooks.add(book);
            }

        }
        return foundBooks;
    }


    // Method to borrow books by ISBN number
    public void borrowBook(int isbn) {
        for (Book book : books) {
            if (book.getIsbn() == isbn) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    System.out.println("Book borrowed. \n" + book);
                } else {
                    System.out.println("This book has already been borrowed. \n" + book);
                }


                return; // Operation completed, exiting the method
            }
        }
        System.out.println("No book found matching the ISBN number.\n");
    }


    // Method to return books by ISBN number
    public void returnBook(int isbn) {
        for (Book book : books) {
            if (book.getIsbn() == isbn) {
                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    System.out.println("Book returned\n" + book);
                    return;
                } else {
                    System.out.println("This book has already been returned\n" + book);
                    return;
                }
            }
        }
        System.out.println("No book found matching the ISBN number.");
    }

}

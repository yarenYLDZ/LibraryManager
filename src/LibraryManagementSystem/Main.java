package LibraryManagementSystem;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LibraryManager library = new LibraryManager();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false; // Controls the main loop remains false until the user chooses to exit

        while (!exit) {
            System.out.println("\n--------*** LIBRARY MANAGER SYSTEM ***--------");
            System.out.println("                     MAIN MENU");
            System.out.println("   Press 1 to add a book");
            System.out.println("   Press 2 to list books");
            System.out.println("   Press 3 to search for a book");
            System.out.println("   Press 4 to borrow a book");
            System.out.println("   Press 5 to return a book");
            System.out.println("   Press 6 to exit");
            System.out.print("   Please enter the operation you want to perform : ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    // Prompt user to enter details for a new book
                    System.out.println("Please enter the details of the book you want to add in order :");
                    System.out.print("Book title: ");
                    String name = scanner.nextLine();
                    System.out.print("Author name: ");
                    String author = scanner.nextLine();

                    // Validate numeric ISBN input
                    int isbn;
                    while (true) {
                        try {
                            System.out.print("ISBN: ");
                            isbn = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid ISBN! Please enter a numeric value.");
                        }
                    }

                    System.out.print("Genre: ");
                    String genre = scanner.nextLine();

                    // Validate numeric publish year input
                    int publishYear;
                    while (true) {
                        try {
                            System.out.print("Publish year: ");
                            publishYear = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid year! Please enter a numeric value.");
                        }
                    }

                    // Create new Book object and add it to the library
                    Book newBook = new Book(name, author, isbn, genre, publishYear);
                    library.addBook(newBook);
                    break;

                case "2":
                    // List all books in the library
                    library.listBooks();
                    break;

                case "3":
                    // Search for books by title
                    System.out.print("Book title to search: ");
                    String searchTitle = scanner.nextLine();
                    List<Book> foundBooks = library.searchBookByTitle(searchTitle);
                    if (foundBooks.isEmpty()) {
                        System.out.println("The book you searched for was not found.");
                    } else {
                        System.out.println("Search results:");
                        for (Book book : foundBooks) {
                            System.out.println(book);
                        }
                    }
                    break;

                case "4":
                    // Prompt user to enter ISBN for borrowing a book with validation
                    int borrowIsbn;
                    while (true) {
                        try {
                            System.out.print("Please enter the ISBN number of the book you want to borrow : ");
                            borrowIsbn = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid ISBN! Please enter a numeric value.");
                        }
                    }
                    library.borrowBook(borrowIsbn);
                    break;

                case "5":
                    // Prompt user to enter ISBN for returning a book with validation
                    int returnIsbn;
                    while (true) {
                        try {
                            System.out.print("Please enter the ISBN number of the book you want to return : ");
                            returnIsbn = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid ISBN! Please enter a numeric value.");
                        }
                    }
                    library.returnBook(returnIsbn);
                    break;

                case "6":
                    // Exit the program
                    System.out.println("Exiting the program. Have a nice day! ");
                    exit = true;
                    break;

                default:
                    // Handle invalid menu options
                    System.out.println("Invalid choice. Please try again. ");
            }
        }

        scanner.close();
    }
}

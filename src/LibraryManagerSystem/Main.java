package LibraryManagerSystem;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LibraryManager library = new LibraryManager();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

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
                    // Section where book information is requested from the user
                    System.out.println("Please enter the details of the book you want to add in order :");
                    System.out.print("Book title: ");
                    String name = scanner.nextLine();
                    System.out.print("Author name: ");
                    String author = scanner.nextLine();
                    System.out.print("ISBN: ");
                    int isbn = Integer.parseInt(scanner.nextLine());
                    System.out.print("Genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Publish year: ");
                    int publishYear = Integer.parseInt(scanner.nextLine());

                    Book newBook = new Book(name, author, isbn, genre, publishYear);
                    library.addBook(newBook); // Call method to add a new book to the library
                    break;

                case "2":
                    // Call method to list all books in the library
                    library.listBooks();
                    break;

                case "3":

                    System.out.print("Book title to search: ");
                    String searchTitle = scanner.nextLine();
                    List<Book> foundBooks = library.searchBookByTitle(searchTitle); // Call method to search for books by title
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

                    System.out.print("Please enter the ISBN number of the book you want to borrow : ");
                    int borrowIsbn = Integer.parseInt(scanner.nextLine());
                    library.borrowBook(borrowIsbn); // Call method to borrow a book by ISBN
                    break;

                case "5":

                    System.out.print("Please enter the ISBN number of the book you want to return : ");
                    int returnIsbn = Integer.parseInt(scanner.nextLine());
                    library.returnBook(returnIsbn); // Call method to return a book by ISBN
                    break;

                case "6":
                    System.out.println("Exiting the program. Have a nice day! ");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again. ");
            }
        }

        scanner.close();
    }
}

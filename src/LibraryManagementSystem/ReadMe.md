# Library Management System

## Project Overview

This is a simple Library Management System implemented in Java. It allows users to manage a collection of books via a console-based interface, supporting operations such as adding books, listing all books, searching by title, borrowing, and returning books. The system ensures unique ISBNs for each book and provides clear feedback messages.

## Technologies Used

- Java SE (Standard Edition)
- Java Collections Framework (e.g., `HashMap`)
- Console input/output via `Scanner`

## Features

- Add new books with unique ISBNs
- List all books with detailed information
- Search books by title (case-insensitive)
- Borrow books if available
- Return borrowed books
- User-friendly input validation and error messages

## Project Structure

- **Book** class: Holds book details and availability status.
- **LibraryManager** class: Manages the collection of books and performs operations.
- **Main** class: Provides the user interface and handles menu navigation.

## How to Use

When the program runs, a menu is displayed:

1. Add a book
2. List books
3. Search for a book
4. Borrow a book
5. Return a book
6. Exit

Follow the prompts to perform the desired operation.

## How to Run

1. Make sure you have Java Development Kit (JDK) installed (Java 8 or above recommended).
2. Clone or download the project source code.
3. Open the project in your preferred Java IDE (Eclipse, IntelliJ IDEA, NetBeans) or compile via command line.
4. Compile and run the `Main` class located in the `LibraryManagementSystem` package.
5. Follow the interactive console menu to use the system.



# Library Management System

## Project Overview
This project is a simple **Library Management System** developed in Java. It provides a console-based interface for users to manage a collection of books. Users can add books, list all books, search books by title, borrow books, and return books. The system prevents books from being borrowed if they are already checked out and performs basic input validation.

## Features
- Add books with unique ISBN
- List all books with detailed information
- Search books by title (case insensitive)
- Borrow books by ISBN if available
- Return borrowed books by ISBN
- Menu-driven console user interface

## Technologies Used
- Java SE (Standard Edition)
- Java Collections Framework (ArrayList)
- Console Input/Output (Scanner and System.out)

## How to Run
1. Ensure Java JDK is installed on your computer (preferably version 8 or above).
2. Compile the `Book.java`, `LibraryManager.java`, and `Main.java` files using your preferred IDE or command line.
3. Run the `Main` class to start the console application.
4. Follow the on-screen menu options to use the library system.

## Usage Example
- When adding a book, enter the title, author, ISBN, genre, and publish year in order.
- List all books currently in the library.
- Search books by entering part or full title (case insensitive).
- Borrow or return a book by entering its ISBN number.
- Choose the exit option to quit the program.

## Notes
- ISBN numbers must be numeric and unique.
- The system does not currently save data persistently; all data is lost when the program closes.
- Numeric inputs are validated for correctness.  

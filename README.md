# Library Management System 📚
A console-based application built using Java and JDBC that enables efficient management of books in a library. This project showcases basic CRUD operations and demonstrates database connectivity using JDBC.

Features
Book Management:
Add new books to the library.
View all available books.
Update the status of a book (e.g., Available, Borrowed).
Delete books from the system.
Tech Stack
Programming Language: Java
Database: MySQL
Libraries/Technologies: JDBC
Database Schema
Run the following SQL commands to set up the database:

sql
Copy code
CREATE DATABASE library;

USE library;

CREATE TABLE Books (
    BookID INT AUTO_INCREMENT PRIMARY KEY,
    Title VARCHAR(100),
    Author VARCHAR(100),
    Genre VARCHAR(50),
    Status VARCHAR(20) DEFAULT 'Available'
);
How to Run
Prerequisites
Java JDK 8 or higher.
MySQL installed and running.
A code editor (e.g., IntelliJ IDEA, Eclipse, or VS Code).
Steps
Clone this repository:
bash
Copy code
git clone https://github.com/your-username/library-management-system.git
Set up the database using the provided SQL script.
Update the database credentials in the DatabaseConnection class:
java
Copy code
private static final String URL = "jdbc:mysql://localhost:3306/library";
private static final String USER = "your-username";
private static final String PASSWORD = "your-password";
Compile and run the LibraryManagementSystem.java file:
bash
Copy code
javac LibraryManagementSystem.java
java LibraryManagementSystem

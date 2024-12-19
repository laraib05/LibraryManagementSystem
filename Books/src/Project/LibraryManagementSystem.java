package Project;

import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookDAO bookDAO = new BookDAO();

        while (true) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add a Book");
            System.out.println("2. View Books");
            System.out.println("3. Update Book Status");
            System.out.println("4. Delete a Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.next();
                    System.out.print("Enter author name: ");
                    String author = scanner.next();
                    System.out.print("Enter genre: ");
                    String genre = scanner.next();
                    bookDAO.addBook(title, author, genre);
                    break;
                case 2:
                    bookDAO.viewBooks();
                    break;
                case 3:
                    System.out.print("Enter Book ID: ");
                    int bookId = scanner.nextInt();
                    System.out.print("Enter new status (Available/Borrowed): ");
                    String status = scanner.next();
                    bookDAO.updateBookStatus(bookId, status);
                    break;
                case 4:
                    System.out.print("Enter Book ID to delete: ");
                    int deleteBookId = scanner.nextInt();
                    bookDAO.deleteBook(deleteBookId);
                    break;
                case 5:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

package Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDAO {
    public void addBook(String title, String author, String genre) {
        String sql = "INSERT INTO Books (Title, Author, Genre) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, title);
            stmt.setString(2, author);
            stmt.setString(3, genre);
            stmt.executeUpdate();
            System.out.println("Book added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewBooks() {
        String sql = "SELECT * FROM Books";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            System.out.printf("%-5s %-30s %-30s %-20s %-15s%n", "ID", "Title", "Author", "Genre", "Status");
            System.out.println("-----------------------------------------------------------------------------------");
            while (rs.next()) {
                System.out.printf("%-5d %-30s %-30s %-20s %-15s%n",
                        rs.getInt("BookID"),
                        rs.getString("Title"),
                        rs.getString("Author"),
                        rs.getString("Genre"),
                        rs.getString("Status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBookStatus(int bookId, String status) {
        String sql = "UPDATE Books SET Status = ? WHERE BookID = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, status);
            stmt.setInt(2, bookId);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Book status updated successfully!");
            } else {
                System.out.println("Book not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(int bookId) {
        String sql = "DELETE FROM Books WHERE BookID = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, bookId);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Book deleted successfully!");
            } else {
                System.out.println("Book not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


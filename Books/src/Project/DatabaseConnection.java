package Project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;


public class DatabaseConnection {
	static String url = "jdbc:mysql://localhost:3306/jdb_ca6_3pm";
	static String user ="root";
	static String pass = "L@raib#17";
	
	public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }
}

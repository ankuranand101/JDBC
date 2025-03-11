
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    public static void main(String[] args){
        // Database URL, username, and password
        String url = "jdbc:mysql://localhost:3306/student"; // Replace 'your_database' with your actual database name
        String user = "root"; // Replace with your MySQL username
        String password = "4079"; // Replace with your MySQL password

        // Establish connection
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the MySQL database successfully!");

            // Close the connection
            conn.close();
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}

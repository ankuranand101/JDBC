import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/student";
        String username = "root";
        String password = "4079";
        String Query = "INSERT INTO info (id, name, `class`, roll) VALUES (?, ?, ?, ?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // Updated driver class
            System.out.println("Driver loaded Successfully");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e.getMessage());
            return;
        }

        try (Connection con = DriverManager.getConnection(url, username, password);
             Scanner sc = new Scanner(System.in)) {

            System.out.println("Connection established");

            System.out.print("Enter the ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // Consume newline

            System.out.print("Enter the Name: ");
            String name = sc.nextLine();

            System.out.print("Enter the Class: ");
            String cl = sc.nextLine();

            System.out.print("Enter the Roll: ");
            int roll = sc.nextInt();

            // Prepare statement
            PreparedStatement ps = con.prepareStatement(Query);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, cl);
            ps.setInt(4, roll);

            // Execute update (DO NOT pass the Query again)
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Insertion successful! " + rowsAffected + " row(s) affected");
            } else {
                System.out.println("Insertion failed");
            }

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }
}

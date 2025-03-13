import java.sql.*;

public class DataInsertion {
    public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/DATABASE_NAME";
        String username = "root";
        String password = "YOUR_PASSWORD";
        String query = "INSERT INTO Info(id, name, class, roll) VALUES (6, 'Shubham', 'CMA', 205);";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Updated driver class name
            System.out.println("Driver loaded Successfully");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found: " + e.getMessage());
        }

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();
            System.out.println("Connection established");
            int rowsAffected = st.executeUpdate(query);

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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataUpdate {
    public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/DATABSE_NAME";
        String username = "root";
        String password = "Your Password";
        String query = "UPDATE Info \n"+ "SET name = 'Gauri', class = '2nd Yr' \n" + "WHERE id = 3;";

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
                System.out.println("Update successful! " + rowsAffected + " row(s) affected");
            } else {
                System.out.println("Update failed");
            }

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }
}

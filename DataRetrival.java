import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class DataRetrival {
    public static void main(String[] args)throws ClassNotFoundException{
        String url = "jdbc:mysql://localhost:3306/student";
        String username = "root";
        String password = "4079";
        String query = "Select * from Info;";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded Sucessfully");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("connection done");
            Statement st = con.createStatement();
            ResultSet re = st.executeQuery(query);//using for retrival of data
            while(re.next()){
                int id = re.getInt("id");
                String cl = re.getString("class");
                String name = re.getString("name");
                int roll = re.getInt("roll");
                System.out.println("===================================");
                System.out.println();
                System.out.println("id : " + id);
                System.out.println("name: " + name);
                System.out.println("class: " + cl);
                System.out.println("Roll: " + roll);
                System.out.println();

            }
            st.close();
            re.close();
            System.out.println("connection closed !!");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }
}

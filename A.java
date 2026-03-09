import java.sql.*;

public class A {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/apply";
        String user = "root";
        String pass = "Prince@567899";

        try {

            // 1 Driver Load
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2 Connection
            Connection con = DriverManager.getConnection(url, user, pass);

            System.out.println("Database Connected");

            // 3 Insert Query
            String query = "INSERT INTO data(Full_Name,Dob,Gender,Phone,Address,Course,Marks10,Marks12) VALUES(?,?,?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            // Sample Data (Form ke jaisa)
            ps.setString(1, "Rahul Sharma");
            ps.setString(2, "2005-04-15");
            ps.setString(3, "Male");
            ps.setString(4, "9876543210");
            ps.setString(5, "Jaipur Rajasthan");
            ps.setString(6, "BCA");
            ps.setString(7, "82");
            ps.setString(8, "76");

            int i = ps.executeUpdate();

            if (i > 0) {
                System.out.println("Student Data Inserted Successfully");
            } else {
                System.out.println("Insert Failed");
            }

            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}
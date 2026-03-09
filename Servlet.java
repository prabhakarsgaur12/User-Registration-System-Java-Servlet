import java.io.*;
import java.sql.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {

protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {

response.setContentType("text/html");
PrintWriter out = response.getWriter();

String name = request.getParameter("fullname");
String dob = request.getParameter("dob");
String gender = request.getParameter("gender");
String phone = request.getParameter("phone");
String address = request.getParameter("address");
String course = request.getParameter("course");
String marks10 = request.getParameter("marks10");
String marks12 = request.getParameter("marks12");

try{

Class.forName("com.mysql.cj.jdbc.Driver");

Connection con = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/apply",
"root",
"Prince@567899"
);

String query = "INSERT INTO data(Full_Name,Dob,Gender,Phone,Address,Course,Marks10,Marks12) VALUES(?,?,?,?,?,?,?,?)";

PreparedStatement ps = con.prepareStatement(query);

ps.setString(1,name);
ps.setString(2,dob);
ps.setString(3,gender);
ps.setString(4,phone);
ps.setString(5,address);
ps.setString(6,course);
ps.setString(7,marks10);
ps.setString(8,marks12);

int i = ps.executeUpdate();

out.println("<html><body style='font-family:Arial;text-align:center;'>");

if(i>0){

out.println("<h2 style='color:green;'>Application Submitted Successfully</h2>");

}else{

out.println("<h2 style='color:red;'>Submission Failed</h2>");

}

out.println("<br><a href='apply.html'>Back to Form</a>");

out.println("</body></html>");

con.close();

}catch(Exception e){

out.println("<h3>Error : "+e.getMessage()+"</h3>");

}

}

}
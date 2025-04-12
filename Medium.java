import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class EmployeeServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String id = request.getParameter("id");

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

      Statement stmt = con.createStatement();
      ResultSet rs;

      if (id != null && !id.isEmpty()) {
        rs = stmt.executeQuery("SELECT * FROM employees WHERE id=" + id);
      } else {
        rs = stmt.executeQuery("SELECT * FROM employees");
      }

      out.println("<h2>Employee List</h2>");
      while (rs.next()) {
        out.println("ID: " + rs.getInt(1) + ", Name: " + rs.getString(2) + "<br>");
      }

      con.close();
    } catch (Exception e) {
      out.println("Error: " + e.getMessage());
    }
  }
}

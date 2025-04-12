import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AttendanceServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String id = request.getParameter("id");
    String subject = request.getParameter("subject");
    String attendance = request.getParameter("attendance");

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

      PreparedStatement ps = con.prepareStatement("INSERT INTO attendance (id, subject, percentage) VALUES (?, ?, ?)");
      ps.setString(1, id);
      ps.setString(2, subject);
      ps.setInt(3, Integer.parseInt(attendance));

      int i = ps.executeUpdate();
      if (i > 0) {
        out.println("<h3>Attendance Saved Successfully!</h3>");
      }

      con.close();
    } catch (Exception e) {
      out.println("Error: " + e.getMessage());
    }
  }
}

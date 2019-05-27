package sem4.st;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    name = "HelloAppEngine",
    urlPatterns = {"/hello"}
)
public class HelloAppEngine extends HttpServlet {
	
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {
	  Connection connection = null;
	try {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sem4?useUnicode=true&characterEncoding=utf-8", "root", "");
		String sql = "Insert into account (userName, password) values (?, ?)";
	      PreparedStatement ps = connection.prepareStatement(sql);
	      ps.setString(1, "aaa");
	      ps.setString(2, "bbb");
	      ps.execute();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
     
      System.out.println("Insert success!");
    response.setContentType("text/plain");
    response.setCharacterEncoding("UTF-8");

    response.getWriter().print("Hello App Engine!\r\n");

  }
  
  
}
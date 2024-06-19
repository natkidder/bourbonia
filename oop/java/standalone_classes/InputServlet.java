// LB 652, Book 7, Chapter 2
/* Illustrates an input servlet
   Place class file in c:/tomcat/webapps/servlets-examples/WEB-INF/classes
   Then run http://localhost:8080/servlets-examples/servlet/InputServlet
 */

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class InputServlet extends HttpServlet  {

	public void doGet( HttpServletRequest hsRequestMain, HttpServletResponse hsResponseMain )
			throws IOException, ServletException  {

		String name = hsRequestMain.getParameter( "Name" );  // set up the name text box
		hsResponseMain.setContentType( "text/html" );
		PrintWriter pwMain = hsResponseMain.getWriter();

		pwMain.println("<html>");
		pwMain.println("  <head>");
		pwMain.println("    <title>Input Servlet</title>");
		pwMain.println("  </head>");
		pwMain.println("  <body>");
		pwMain.println("    <h1>");
		pwMain.println("      Hello " + name );
		pwMain.println("    </h1>");
		pwMain.println("  </body>");
		pwMain.println("</html>");
	}

	public void doPost( HttpServletRequest hsRequestMain, HttpServletResponse hsResponseMain )
			throws IOException, ServletException  {
		doGet( hsRequestMain, hsResponseMain );
	}
}

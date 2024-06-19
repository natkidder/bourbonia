// LB 647, Book 7, Chapter 2
/* Illustrates servlets
   Place class file in c:/tomcat/webapps/servlets-examples/WEB-INF/classes
   Then run http://localhost:8080/servlets-examples/servlet/ServletHelloWorld
 */

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ServletHelloWorld extends HttpServlet   {

	public void doGet( HttpServletRequest hsRequestMain, HttpServletResponse hsResponseMain )
			throws IOException, ServletException {

		hsResponseMain.setContentType( "text/html" );
		PrintWriter prMain = hsResponseMain.getWriter();
		prMain.println( "<html>" );
		prMain.println( "  <head>" );
		prMain.println( "    <title>ServletHelloWorld</title>" );
		prMain.println( "  </head>" );
		prMain.println( "  <body>" );
		prMain.println( "    <h1>Hello World</h1>" );
		prMain.println( "  </body>" );
		prMain.println( "</html>" );
	}

	public void doPost( HttpServletRequest hsRequestMain, HttpServletResponse hsResponseMain )
			throws IOException, ServletException {
		doGet( hsRequestMain, hsResponseMain );
	}
}

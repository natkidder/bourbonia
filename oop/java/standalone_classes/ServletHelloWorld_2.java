// LB 650, Book 7, Chapter 2
/* Illustrates servlets
   Place class file in c:/tomcat/webapps/servlets-examples/WEB-INF/classes
   Then run http://localhost:8080/servlets-examples/servlet/ServletHelloWorld_2
 */

 import java.io.*;
 import javax.servlet.*;
 import javax.servlet.http.*;

 public class ServletHelloWorld_2 extends HttpServlet  {

	 public void doGet( HttpServletRequest hsRequestMain, HttpServletResponse hsResponseMain )
	 		throws IOException, ServletException   {

		hsResponseMain.setContentType( "text/html" );
		PrintWriter pwMain = hsResponseMain.getWriter();
		String msg = this.getGreeting();

		pwMain.println("<html>");
		pwMain.println("  <head>");
		pwMain.println("    <title>Hello World Servlet 2</title>");
		pwMain.println("  </head>");
		pwMain.println("  <body>");
		pwMain.println("    <h1>");
		pwMain.println("      " + msg );
		pwMain.println("    </h1>");
		pwMain.println("  </body>");
		pwMain.println("</html>");
	}

	public void doPost( HttpServletRequest hsRequestMain, HttpServletResponse hsResponseMain )
			throws IOException, ServletException  {
		doGet( hsRequestMain, hsResponseMain );
	}

	private String getGreeting()  {
		String msg = "";
		int iRand = (int)( Math.random() * 6 ) + 1;
		switch ( iRand )  {
			case 1:
				return "Hello World";
			case 2:
				return "Greetings";
			case 3:
				return "Felicitations";
			case 4:
				return "Yo, dude";
			case 5:
				return "What's up?";
			case 6:
				return "Hark!";
		}
		return null;  // any method that returns a type may return null
	}
}

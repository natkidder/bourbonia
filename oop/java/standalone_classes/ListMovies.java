// LB 657, Book 7, Chapter 2
/* works with Movie, MovieIO, Movies.txt
   Place class file in c:/tomcat/webapps/servlets-examples/WEB-INF/classes
 */

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class ListMovies extends HttpServlet  {

	public void doGet( HttpServletRequest hsRequest, HttpServletResponse hsResponse )
			throws IOException, ServletException  {
		hsResponse.setContentType( "text/html" );
		PrintWriter pw = hsResponse.getWriter();
		String msg = getMovieList( "c:/tomcat/webapps/servlets-examples/Movies.txt" );
		pw.println( "<html>" );
		pw.println( "  <head>" );
		pw.println( "    <title>List Movies</title>" );
		pw.println( "  </head>" );
		pw.println( "  <body>" );
		pw.println( "    <h1>List Movies Servlet</h1>" );
		pw.println( "    <h3>" );
		pw.println( msg );
		pw.println( "    </h3>" );
		pw.println( "  </body>" );
		pw.println( "</html>" );
	}

	public void doPost( HttpServletRequest hsRequest, HttpServletResponse hsResponse )
			throws IOException, ServletException  {
		doGet( hsRequest, hsResponse );
	}

	private String getMovieList( String filename )  {
		String msg = "";
		ArrayList<Movie> movies = MovieIO.getMovies( filename );
		for ( Movie movieSingle : movies )  {
			msg += movieSingle.iYear + ": ";
			msg += movieSingle.title + "<br>";
		}
		return msg;
	}
}

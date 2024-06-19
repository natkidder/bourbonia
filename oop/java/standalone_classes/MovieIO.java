// LB 656, Book 7, Chapter 2
/* works with Movie, ListMovie, Movies.txt
   Place class file in c:/tomcat/webapps/servlets-examples/WEB-INF/classes
 */

import java.io.*;
import java.util.*;

public class MovieIO   {

	private static void prtln( String text ) { System.out.println( text ); }

	public static ArrayList<Movie> getMovies( String InFile )  {   // note the <type>, specified in Movie.java
		ArrayList<Movie> alMovies = new ArrayList<Movie>();  // uses the Movie constructor
		BufferedReader brIn = getReader( InFile );
		Movie movieIn = readMovie( brIn );
		while ( movieIn != null )  {   // note the != null
			alMovies.add( movieIn );
			movieIn	= readMovie( brIn );
		}
		return alMovies;
	}

	private static BufferedReader getReader( String name )  {
		// ASSUMES line to be read in is tab-delimited
		BufferedReader brIn = null;  // note setting the BufferedReader to null
		try  {
			File fileIn = new File( name );
			brIn = new BufferedReader( new FileReader( fileIn ) );
		}
		catch( FileNotFoundException fnfe ) {
			prtln( "File '" + name + "' does not exist" );
			System.exit(0);
		}
		catch( IOException ioe )  {
			prtln( "I/O Error" );
		}
		return brIn;
	}

	private static Movie readMovie( BufferedReader brIn )  {
		String title;
		int iYear;
		double fPrice;
		String line = "";
		String data[];
		try {
			line = brIn.readLine();
		}
		catch ( IOException ioe )  {
			prtln( "I/O Error" );
			System.exit(0);
		}
		if ( line == null )  {  // note BufferedReader line can be compared with null
			return null;
		} else {
			data = line.split( "\t" );
			title = data[0];
			iYear = Integer.parseInt( data[1] );
			fPrice = Double.parseDouble( data[2] );
			return new Movie( title, iYear, fPrice);
		}
	}
}

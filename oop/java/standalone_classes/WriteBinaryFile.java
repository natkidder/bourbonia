/* LB 727, Book 8, Chapter 2
exemplifies writing to a binary file
set the classpath to c:/tomcat/shared/classes if you wish to use c:/tomcat/shared/classes/movie/movie.class
*/

import java.io.*;

public class WriteBinaryFile  {

	public static void main( String[] args )  {
		Movie[] movies = getMovies();

		DataOutputStream dos = openOutputStream( "movies.dat" );
		for ( Movie movie : movies )
			writeMovie( movie, dos );
		closeFile( dos );
	}

	public static Movie[] getMovies()  {
		Movie[] movies = new Movie[10];
		movies[0] = new Movie( "It's a Wonderfule Life" , 1946, 15.00 );
		movies[1] = new Movie( "The Great Race" , 1965, 13.00 );
		movies[2] = new Movie( "Young Frankenstein" , 1974, 17.00 );
		movies[3] = new Movie( "The Return of the Pink Panther" , 1975, 12.00 );
		movies[4] = new Movie( "Star Wars" , 1977, 18.00 );
		movies[5] = new Movie( "The Princess Bride" , 1987, 17.00 );
		movies[6] = new Movie( "Glory" , 1989, 15.00 );
		movies[7] = new Movie( "Apollo 13" , 1995, 20.00 );
		movies[8] = new Movie( "The Game" , 1997, 15.00 );
		movies[9] = new Movie( "The Lord of the Rings" , 2001, 20.00 );
		return movies;
	}

	private static void prtln( String s )  {  System.out.println( s ); }

	private static DataOutputStream openOutputStream( String filename )  {
		DataOutputStream dos = null;
		try  {
			dos = new DataOutputStream( new BufferedOutputStream( new FileOutputStream( filename ) ) );
		}
		catch ( IOException ioe )  {
			prtln( "IO Exception opening " + filename );
			System.exit( 1 );
		}
		return dos;
	}

	private static void writeMovie( Movie movie, DataOutputStream dos )  {
		try {
			dos.writeUTF( movie.title );
			dos.writeInt( movie.year );
			dos.writeDouble( movie.price );
		}
		catch( IOException ioe )  {
			prtln( "IO Exception writing data" );
			System.exit( 2 );
		}
	}

	private static void closeFile( DataOutputStream dos )  {
		try {
			dos.close();
		}
		catch ( IOException ioe )  {
			prtln( ioe.toString() + ": IOException while closing the DataOutputStream" );
			System.exit( 3 );
		}
	}

	private static class Movie {
		public String title;
		public int year;
		public double price;

		public Movie( String title, int year, double price )  {
			this.title = title;
			this.year = year;
			this.price = price;
		}
	}
}

/* LB 716, Book 8, Chapter 2
exemplifies reading in a text file and writing out to a text file
set the classpath to c:/tomcat/shared/classes if you wish to use c:/tomcat/shared/classes/movie/movie.class
*/

import java.io.*;
import java.text.NumberFormat;
//import movie.*;

public class ReadAndWriteTextFile  {

	private static void prtln( String s ) { System.out.println( s ); }

	public static void main( String args[] )  {

		try {
			NumberFormat cf = NumberFormat.getCurrencyInstance();
			BufferedReader brIn = getReader( "c:/mydocs/career/training/java/Movies.txt" );
			String outFileName = "c:/mydocs/career/training/java/MoviesOut.txt";
			File fileOut = new File( outFileName );
			FileWriter fwOut = new FileWriter( fileOut, false );   // overwrite -- true means append
			BufferedWriter bwOut = new BufferedWriter( fwOut );
			PrintWriter pwOut = new PrintWriter( bwOut, true );  // flush mode

			Movie movie = readMovie( brIn );
			while ( movie != null )  {
				String textOut = Integer.toString( movie.year );
				textOut += ":" + movie.title;
				textOut += " (" + cf.format( movie.price ) + ")";
	//			prtln( textOut );
				pwOut.println( textOut );
				movie = readMovie( brIn );
			}
			pwOut.close();
			prtln( "Output in '" + outFileName + "'" );
		}
		catch ( IOException ioe )  {
			prtln( ioe.toString() );
			System.exit( 1 );
		}
	}

	private static BufferedReader getReader( String filename )  {
		BufferedReader brIn = null;
		try {
			File fileMain = new File( filename );
			brIn = new BufferedReader( new FileReader( fileMain ) );
		}
		catch ( FileNotFoundException fnfe )  {
			prtln( "File '" + filename + "' not found" );
			System.exit( 1 );
		}
		return brIn;
	}

	private static Movie readMovie( BufferedReader brIn )  {
		String title;
		int iYear;
		double fPrice;
		String output = "";
		String[] movieFields;

		try  {
			output = brIn.readLine();
		}
		catch ( IOException ioe )  {
			prtln( "IO Exception" );
			System.exit( 2 );
		}

		if ( output == null )  {
			return null;
		} else {
			movieFields = output.split( "\t" );
			title = movieFields[0];
			iYear = Integer.parseInt( movieFields[1] );
			fPrice = Double.parseDouble( movieFields[2] );
			return new Movie( title, iYear, fPrice );      // NOTE you may return an instantiation
		}
	}

	public static class Movie  {
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


/* LB 722, Book 8, Chapter 2
exemplifies reading in a binary file.  You might want to run it after running WriteBinaryFile
set the classpath to c:/tomcat/shared/classes if you wish to use c:/tomcat/shared/classes/movie/movie.class
*/

import java.io.*;
import java.text.NumberFormat;

public class ReadBinaryFile  {

	private static void prtln( String s ) { System.out.println( s ); }

	public static void main( String[] args )  {

		NumberFormat cf = NumberFormat.getCurrencyInstance();
		DataInputStream dis = getStream("c:/mydocs/career/training/java/Movies.dat");
		boolean eof = false;

		while( ! eof )  {
			Movie movie = readMovie( dis );
			if ( movie == null )
				eof = true;
			else  {
				String textOut = Integer.toString( movie.year );
				textOut += ": " + movie.title;
				textOut += "(" + cf.format( movie.price ) + ")";
				prtln( textOut );
			}
		}
		closeFile( dis, "c:/mydocs/career/training/java/Movies.dat" );
	}

	private static DataInputStream getStream( String filename )  {
		DataInputStream dis = null;
		try  {
			File fileIn = new File( filename );
			dis = new DataInputStream( new BufferedInputStream( new FileInputStream( fileIn ) ) );
		}
		catch ( FileNotFoundException fnfe )  {
			prtln( " Could not find " + filename );
			System.exit( 1 );
		}
		catch ( IOException ioe )  {
			prtln( "IO Exception reading" + filename );
			System.exit( 2 );
		}
		return dis;
	}

	private static Movie readMovie( DataInputStream dis )  {
		String title = "";
		int year = 0;
		double price = 0;

		try  {
			title = dis.readUTF();
			year = dis.readInt();
			price = dis.readDouble();
		}
		catch ( EOFException eofe )  {
			return null;               // expected, so swallow
		}
		catch ( IOException ioe )  {
			prtln( "IO Error" );
			System.exit( 1 );
		}
		return new Movie( title, year, price );
	}

	private static void closeFile( DataInputStream dis, String filename )  {
		try {
			dis.close();
		}
		catch( IOException ioe )  {
			prtln( "IO error closing file " + filename );
			System.exit( 1 );
		}
	}

	private static class Movie  {
		String title;
		int year;
		double price;

		public Movie( String title, int year, double price )  {
			this.title = title;
			this.year = year;
			this.price = price;
		}
	}
}

/* LB 778, Book 8, Chapter 5
loads an XML file into a DOM document, then returns attributes/values */

import javax.xml.parsers.*;
import org.xml.sax.*;
import org.w3c.dom.*;
import java.text.*;

public class ListMoviesXML  {

	private static NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

	public static void main( String args[] )  {

		Document document = getDocument( "movies.xml" );

		Element elemRoot = document.getDocumentElement();

		Element elemMovie = (Element)elemRoot.getFirstChild();
		Movie movie;

		while ( elemMovie != null )  {
			movie = getMovie( elemMovie );
			String msg = Integer.toString( movie.year );
			msg += ": " + movie.title;
			msg += " (" + currencyFormat.format( movie.price ) + ")";
			System.out.println( msg );
			elemMovie = (Element)elemMovie.getNextSibling();
		}

	}

	private static Document getDocument( String filename )  {
		try  {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setIgnoringComments( true );
			dbf.setIgnoringElementContentWhitespace( true );
			dbf.setValidating( true );

			DocumentBuilder db = dbf.newDocumentBuilder();
			return db.parse( new InputSource( filename ) );
		}
		catch ( Exception e )  {
			System.out.println( "getDocument: " + e.getMessage() );
		}
		return null;
	}

	private static Movie getMovie( Element element )  {

		// get the year attribute
		String sYear = element.getAttribute( "year" );
		int year = Integer.parseInt( sYear );

		// get the Title element text
		Element elemTitle = (Element)element.getFirstChild();
		String title = getTextValue( elemTitle ).trim();

		// get the Price element value
		Element elemPrice = (Element)elemTitle.getNextSibling();
		String sPrice = getTextValue( elemPrice ).trim();
		Double price = Double.parseDouble( sPrice );

		return new Movie( title, year, price );
	}

	private static String getTextValue( Node node )  {

		return node.getFirstChild().getNodeValue();
	}
}

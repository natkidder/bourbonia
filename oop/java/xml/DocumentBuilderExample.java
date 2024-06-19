/* LB 771, Book 8, Chapter 5
establishes a MySql connection, runs an update */

import javax.xml.parsers.*;
import org.xml.sax.*;
import org.w3c.dom.*;
import java.text.*;

public class DocumentBuilderExample  {

	static final String xmlFilename = "movies.xml";

	public static void main( String[] args )  {

		Document document = getDocument( xmlFilename );

		prtln( getMovieCnt( document ) );
		getNodeNames( document );
		prtln( getEarliestYear( document ) );
		getProfiles( document );
	}

	private static Document getDocument( String filename )  {
		try  {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setIgnoringComments( true );                  // ignore comments in the XML file so DOM processing doesn't have to check for them
			dbf.setIgnoringElementContentWhitespace( true );  // ignore extra whitespace in the XML file to speed up processing
			dbf.setValidating( true );                        // validate the XML file if it specifies a DTD
			DocumentBuilder db = dbf.newDocumentBuilder();
			return db.parse( new InputSource( filename ) );   // actually uses SAX to read in the file
		}
		catch ( ParserConfigurationException pce )  {
			prtln( pce.getMessage() );
		}
		catch ( SAXException se ) {
			prtln( se.getMessage() );
		}
		catch ( Exception e )  {
			System.out.println( e.getMessage() );
		}
		return null;
	}

	private static String getMovieCnt( Document document)  {
		int cnt = 0;
		Element rootElement = document.getDocumentElement();
		Node nodeMovie = rootElement.getFirstChild();
		while ( nodeMovie != null )  {
			cnt++;
			nodeMovie = nodeMovie.getNextSibling();
		}
		return "\nmethod getMovieCnt: There are " + cnt + " movies in " + xmlFilename;
	}

	private static void getNodeNames( Document document )  {

		Element elementRoot = document.getDocumentElement();  // since you're at the root element
		NodeList nodelistMovies = elementRoot.getChildNodes();
		prtln( "\nmethod getNodeNames: Using an item loop for a NodeList:" );

		for ( int i = 0; i < nodelistMovies.getLength(); i++ )  {
			Node nodeMovie = nodelistMovies.item( i );
			prtln( nodeMovie.getNodeName() );           // just lists the element tag, Movie
		}
	}

	private static String getEarliestYear( Document document ) {

		Element elementRoot = document.getDocumentElement();
		Element elementMovie = (Element)elementRoot.getFirstChild();  // must be cast as Element to call getAttribute (only elements have attributes)
		int oldest = 9999;   //

		while ( elementMovie != null )  {
			String sYear = elementMovie.getAttribute( "year" );
			int iYear = Integer.parseInt( sYear );
			if ( iYear < oldest )  {
				oldest = iYear;
			}
			elementMovie = (Element)elementMovie.getNextSibling();
		}
		return "\ngetEarliestYear: The oldest movie in " + xmlFilename + " is " + oldest;
	}

	private static void getProfiles( Document document )  {
		String profile;

		Element elementRoot = document.getDocumentElement();
		Element elementMovie = (Element)elementRoot.getFirstChild();

		while ( elementMovie != null )   {

			profile = "(" + elementMovie.getAttribute( "year" ) + ") ";

			Element elemTitle = (Element)elementMovie.getFirstChild();
			profile += elemTitle.getFirstChild().getNodeValue().trim() + ", ";

			Element elemPrice = (Element)elemTitle.getNextSibling();
			profile += elemPrice.getFirstChild().getNodeValue().trim();

			System.out.println( profile );

			elementMovie = (Element)elementMovie.getNextSibling();
		}
	}

	private static void prtln( Object o ) { System.out.println( o.toString() ); }
}

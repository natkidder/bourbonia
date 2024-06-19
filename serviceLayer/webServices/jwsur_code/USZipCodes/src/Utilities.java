import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


public class Utilities {
	static void parseStringXml(String xmlRecords)  {
	    DocumentBuilder db;
		try {
			db = DocumentBuilderFactory.newInstance().newDocumentBuilder();

			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(xmlRecords));

			Document doc = db.parse(is);
			NodeList nodes = doc.getElementsByTagName("NewDataSet");
			Element line = null;

            printNodes(nodes);
	    } catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	  static String getCharacterDataFromElement(Element e) {
		    Node child = e.getFirstChild();
		    if (child instanceof CharacterData) {
		      CharacterData cd = (CharacterData) child;
		      return cd.getData();
		    }
		    return "";
	  }
	  
	  static void printNodes(NodeList nodes)  {
		  Element line;
			for (int i = 0; i < nodes.getLength(); i++) {
				Element element = (Element) nodes.item(i);
	
				for (AddressElems a : AddressElems.values())  {
					//System.out.println("a="+a.toString()); ////
					NodeList name = element.getElementsByTagName(a.toString());
					line = (Element) name.item(0);
					System.out.println(a.toString()+ ": " + getCharacterDataFromElement(line));					
				}
				System.out.println("");
	
			}				  
	  }
	  
	  static void printZips(Element e)  {
		  NodeList zips = e.getChildNodes();
		  printNodes(zips);
/*		  for (int i=0; i < zips.getLength(); i++)  {
			  printNodes(zips.item(i).getChildNodes());
		  }*/
	  }
}

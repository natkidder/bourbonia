package com.programmingfree.springservice.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class XMLUtils {

	/**
	 *
	 * Convert a string to a Node Object
	 *
	 * @param xml The xml to convert
	 * @return A document Object
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public static Node stringToNode(String xml)  {
		Node node = null;
		if (xml == null)
			return null;

		try {
			Document document = inputStream2Document(new ByteArrayInputStream(xml.getBytes()));
			node = document.getFirstChild();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return node;

	}

	/**
	 * Convert an inputStream to a Document Object
	 * @param inputStream The inputstream to convert
	 * @return a Document Object
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public static Document inputStream2Document(InputStream inputStream) throws IOException, SAXException, ParserConfigurationException {
		DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
		newInstance.setNamespaceAware(true);
		Document parse = newInstance.newDocumentBuilder().parse(inputStream);
		return parse;
	}
}

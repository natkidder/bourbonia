package com.mkyong.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.mkyong.ws.AuditTrailConstants;

public class XMLUtils {

	/*
	 * @Param root root node
	 * @Param pattern XPath regex pattern
	 * @Param attributeToMatch to differentiate from another that matches nodename only  If 0, then match the node's XPath
	 */
	public static Node findNode( Node root, Pattern pattern, int attributeToMatch) {
		//Check to see if root has any children if not return null
		if (!(root.hasChildNodes()))
			return null;
		//Root has children, so continue searching for them
		Node matchingNode = null;
		String nodeName = null;
		Node child = null;
		NodeList childNodes = root.getChildNodes();
		int nbrChildren = childNodes.getLength();
		for (int i = 0; i < nbrChildren; i++) {
			if (matchingNode == null) {
				child = childNodes.item(i);
				String xpath = "";
				if (attributeToMatch == AuditTrailConstants.NODE_PROPERTY_XPATH) {
				    xpath = genXPath(child);
				} else if (attributeToMatch == 2) {   //TODO change 2 to AuditTrailConstants.NODE_PROPERTY_REL_XPATH
					xpath = genXPath(root, child); 
				}
				if (pattern.matcher(xpath).matches() && attributeToMatch == AuditTrailConstants.NODE_PROPERTY_XPATH )
					return child;
				matchingNode =	findNode(child, pattern, attributeToMatch);
			} else
				break;
		}
		return matchingNode;
	}
	
    public static String genXPath(Node node)  {
    	if (node == null)  {  return "-Node argument does not exist-"; }
    	Node parent = node.getParentNode();
    	if (parent == null) {
    		return "/" + node.getNodeName();
    	}
    	return genXPath(parent) + "/" + node.getNodeName();
    }
    
    public static String genXPath(Node rootNode, Node node)  {
    	List<String> nodeNames = new ArrayList<String>();
    	while (node == null || !node.isEqualNode(rootNode)) {
    		nodeNames.add(node.getNodeName());
    		node = node.getParentNode();
    	}
    	nodeNames.add(rootNode.getNodeName());
    	StringBuilder stringBuilder = new StringBuilder();
    	for(int i=nodeNames.size()-1; i>-1; i-- )  {
    		stringBuilder.append("/"+nodeNames.get(i));
    	}
    	return stringBuilder.toString();
    }	
	/*
	 * @Param document DOM document
	 * @Param elementName name of element
	 * @Param pattern xpath pattern that matches xpath of node you want to match
	 * TODO remove this method if unused
	 */
	public List<Node> collectAllNodes(Document document, String elementName, Pattern pattern ) {
		NodeList nodeList = document.getElementsByTagName(elementName);
		Node root = document.getFirstChild();
		List<Node> nodes = new ArrayList<Node>();
		for (int i=0; i<nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			Node matchNode = findNode(root, pattern, AuditTrailConstants.NODE_PROPERTY_XPATH);
			if (matchNode != null) {
				nodes.add(matchNode);
			}
		}
		if (nodes.size() < 1) {
			nodes = null;
		} 
		return nodes;
	}
	
	//TODO change doc to document
	public static Document buildEmptyDoc()  {
		Document doc = null;
		try {
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			doc = builder.newDocument();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doc;

	}
	
	
}

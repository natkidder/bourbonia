package com.mkyong.client;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.soap.MTOMFeature;
import javax.xml.ws.soap.SOAPBinding;
 






import org.w3c.dom.Document;

import com.mkyong.utils.XMLUtils;
import com.mkyong.ws.StreamServer;
 
public class StreamClient{
 
	public static void main(String[] args) throws Exception {
 
	URL url = new URL("http://localhost:9999/sandbox/ws/stream?wsdl");
        QName qname = new QName("http://ws.mkyong.com/", "StreamServerImplService");
 
        Service service = Service.create(url, qname);
        StreamServer streamServer = service.getPort(StreamServer.class);
        
/*		InputStream inputStream1 = new FileInputStream("request.xml");
		// Note to programmer: you cannot reuse an inputStream for creating an XML document
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		Document document = docBuilder.parse(inputStream1);*/
 
        /************  test download  ***************/
        byte[] inputStream = streamServer.downloadStream("c:/tmp/userguide.pdf");
 
        /************  test upload *************/
        
        Document outDocument = XMLUtils.buildEmptyDoc();
        String exitStatus = streamServer.uploadStream(inputStream, "c:\\tmp\\userguideCopy.pdf", "copying done");
 
        System.out.println("exitStatus: " + exitStatus);
 
    }
 
}
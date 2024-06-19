package com.javacodegeeks.enterprise.ws;

import java.awt.Image;
import java.io.File;
import java.net.URL;
 

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import org.apache.log4j.Logger;
 

import com.javacodegeeks.enterprise.ws.jaxws.ImageServerImpl;
import com.javacodegeeks.enterprise.ws.jaxws.ImageServerInterface;
 
public class WebServiceClient {
 
	static Logger log = Logger.getLogger(WebServiceClient.class.getName());
	
    public static void main(String[] args) throws Exception {
 
        URL url = new URL("http://localhost:9999/webservice/imageService?wsdl");
        QName qname = new QName("http://jaxws.ws.enterprise.javacodegeeks.com/", "ImageServerImplService");
 
        Service service = Service.create(url, qname);
        ImageServerInterface imageServer = service.getPort(ImageServerInterface.class);
        log.info("0741-10");
 
        /********* Download ***********/
        String path = "";
        File imageFile = new File("C:\\tmp\\VictoriaFalls.jpg");
        Image image = ImageIO.read(imageFile);
        imageServer.downloadImage("ZambeziRiver.jpg", image);
        //display the received image in a frame
        JFrame frame = new JFrame();
        frame.setSize(800, 800);
        JLabel label = new JLabel(new ImageIcon(image));
        frame.add(label);
        frame.setVisible(true);
        
        /********* Upload *************/
        Image imageToUpload = ImageIO.read(new File("C:\\tmp\\ZambeziRiver.jpg"));
 
        //enable MTOM
        BindingProvider bindingProvider = (BindingProvider) imageServer;
        SOAPBinding sopadBinding = (SOAPBinding) bindingProvider.getBinding();
        sopadBinding.setMTOMEnabled(true);
 
        if (imageToUpload == null)  {  System.out.println("imageToUpload is null");  }  else {  System.out.println("imageToUpload is not null");  }
        String serverStatus = "";
        imageServer.uploadImage(imageToUpload, serverStatus);
        log.info("Server returned Status : " + serverStatus);
 
    }
 
}

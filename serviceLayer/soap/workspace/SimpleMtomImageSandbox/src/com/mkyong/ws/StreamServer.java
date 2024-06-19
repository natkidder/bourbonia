package com.mkyong.ws;

import java.awt.Image;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import org.w3c.dom.Document;
 
//Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.RPC)
public interface StreamServer {
 
	//download a image from server
	@WebMethod byte[] downloadStream(String name);
 
	//update image to server
	@WebMethod String uploadStream(byte[] inputStream, String outputFileName, String message);
 
}
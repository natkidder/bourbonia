package com.mkyong.ws;

import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
 



import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.jws.WebService;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.MTOM;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
 
//Service Implementation Bean
@MTOM
@WebService(endpointInterface = "com.mkyong.ws.StreamServer")
public class StreamServerImpl implements StreamServer {
 
	@Override
	public byte[] downloadStream(String name) {
		
/*		String name = "";
		NodeList nodeList = document.getElementsByTagName("file");
		for (int i=0; i<nodeList.getLength(); i++)
		{
			NodeList nodeList2 = nodeList.item(i).getChildNodes();
			boolean isCorrectMotherNode = false;
			for (int j=0; j<nodeList2.getLength(); j++)  {
				Node node = nodeList2.item(j);
				if (node.getNodeName().equals("direction") && node.getTextContent().equals("download")) {
					isCorrectMotherNode = true;
				}
				if (isCorrectMotherNode && node.getNodeName().equals("path"))  {
					name = node.getTextContent();
				}
			}
		}*/
		log("Reading in binary file named : " + name);
		File file = new File(name);
		log("File size: " + file.length());
		byte[] result = new byte[(int)file.length()];
		try {
			InputStream input = null;
			try {
				int totalBytesRead = 0;
				input = new BufferedInputStream(new FileInputStream(file));
				while(totalBytesRead < result.length){
					int bytesRemaining = result.length - totalBytesRead;
					//input.read() returns -1, 0, or more :
					int bytesRead = input.read(result, totalBytesRead, bytesRemaining); 
					if (bytesRead > 0){
						totalBytesRead = totalBytesRead + bytesRead;
					}
				}
				/*
         the above style is a bit tricky: it places bytes into the 'result' array; 
         'result' is an output parameter;
         the while loop usually has a single iteration only.
				 */
				log("Num bytes read: " + totalBytesRead);
			}
			finally {
				log("Closing input stream.");
				input.close();
			}
		}
		catch (FileNotFoundException ex) {
			log("File not found.");
		}
		catch (IOException ex) {
			log(ex);
		}
		return result;
	}
 
	@Override
	public String uploadStream(byte[] inputStream, String outputFileName, String message) throws WebServiceException {

		log("Writing binary file...");
		String exitStatus = "";
		try {
			OutputStream output = null;
			try {
				output = new BufferedOutputStream(new FileOutputStream(outputFileName));
				output.write(inputStream);
				exitStatus = "written to "+outputFileName+" message="+message;
			}
			finally {
				output.close();
			}
		}
		catch(FileNotFoundException ex){
			log("File not found.");
			exitStatus = "file not found";
		}
		catch(IOException ex){
			log(ex);
			exitStatus = "problem with reading/writing the file";
		} finally {
			return exitStatus;
		}
		
		//throw new WebServiceException("Upload Failed!");

	}
 
	/** Read the given binary file, and return its contents as a byte array.*/ 
	byte[] readAlternateImpl(String aInputFileName){
		log("Reading in binary file named : " + aInputFileName);
		File file = new File(aInputFileName);
		log("File size: " + file.length());
		byte[] result = null;
		try {
			InputStream input =  new BufferedInputStream(new FileInputStream(file));
			result = readAndClose(input);
		}
		catch (FileNotFoundException ex){
			log(ex);
		}
		return result;
	}

	/**
   Read an input stream, and return it as a byte array.  
   Sometimes the source of bytes is an input stream instead of a file. 
   This implementation closes aInput after it's read.
	 */
	byte[] readAndClose(InputStream aInput){
		//carries the data from input to output :    
		byte[] bucket = new byte[32*1024]; 
		ByteArrayOutputStream result = null; 
		try  {
			try {
				//Use buffering? No. Buffering avoids costly access to disk or network;
				//buffering to an in-memory stream makes no sense.
				result = new ByteArrayOutputStream(bucket.length);
				int bytesRead = 0;
				while(bytesRead != -1){
					//aInput.read() returns -1, 0, or more :
					bytesRead = aInput.read(bucket);
					if(bytesRead > 0){
						result.write(bucket, 0, bytesRead);
					}
				}
			}
			finally {
				aInput.close();
				//result.close(); this is a no-operation for ByteArrayOutputStream
			}
		}
		catch (IOException ex){
			log(ex);
		}
		return result.toByteArray();
	}

	private static void log(Object aThing){
		System.out.println(String.valueOf(aThing));
	}

}


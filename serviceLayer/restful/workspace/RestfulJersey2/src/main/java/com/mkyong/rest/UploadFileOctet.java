package com.mkyong.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

@Path("/fileOctet")
public class UploadFileOctet {
	
    @POST
    @Path("/uploadOctet")
    @Consumes(MediaType.APPLICATION_OCTET_STREAM)
         public Response uploadAttachment(InputStream attachmentInputStream) {
		
		System.out.println("0905-10");
 
		//String uploadedFileLocation = "c://nat//tmp/" + fileDetail.getFileName();
		String uploadedFileLocation = "c://nat//tmp//golf.jpg";

		System.out.println("0905-20");
		
		// save it
		writeToFile(attachmentInputStream, uploadedFileLocation);
		System.out.println("0905-30");
 
		String output = "File uploaded to : " + uploadedFileLocation;
		System.out.println("0905-40");
 
		return Response.status(200).entity(output).build();
 
	}

    @POST
    @Path("/uploadOctet2/{attachmentName}")
    @Consumes(MediaType.APPLICATION_OCTET_STREAM)
         public Response uploadAttachment2(@PathParam("attachmentName") String attachmentName, InputStream attachmentInputStream) {
		
		System.out.println("0905-10");
 
		//String uploadedFileLocation = "c://nat//tmp/" + fileDetail.getFileName();
		String uploadedFileLocation = "c://nat//tmp//"+attachmentName;

		System.out.println("0905-20");
		
		// save it
		writeToFile(attachmentInputStream, uploadedFileLocation);
		System.out.println("0905-30");
 
		String output = "File uploaded to : " + uploadedFileLocation;
		System.out.println("0905-40 - "+output);
 
		return Response.status(200).entity(output).build();
 
	}
    
    @POST
    @Path("/uploadOctet3/{attachmentName}")
    @Consumes(MediaType.APPLICATION_OCTET_STREAM)
         public Response uploadAttachment3(@DefaultValue("golf4.jpg") @QueryParam("attachmentName") String attachmentName, InputStream attachmentInputStream) {
		
		System.out.println("1458-10 - "+attachmentName);
		String uploadedFileLocation = "c://nat//tmp//"+attachmentName;

		System.out.println("1458-20");
		
		// save it
		writeToFile(attachmentInputStream, uploadedFileLocation);
		System.out.println("1458-30");
 
		String output = "File uploaded to : " + uploadedFileLocation;
		System.out.println("1458-40 - "+output);
 
		return Response.status(200).entity(output).build();
 
	}
    
	// save uploaded file to new location
	private void writeToFile(InputStream uploadedInputStream,
		String uploadedFileLocation) {
 
		try {
			OutputStream out = new FileOutputStream(new File(
					uploadedFileLocation));
			int read = 0;
			byte[] bytes = new byte[1024];
 
			out = new FileOutputStream(new File(uploadedFileLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
	        out = null;
	        System.gc();
		} catch (IOException e) {
			e.printStackTrace();
		}
 
	}
}

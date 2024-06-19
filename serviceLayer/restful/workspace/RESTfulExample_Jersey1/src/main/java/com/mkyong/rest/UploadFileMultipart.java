package com.mkyong.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

@Path("/fileMultipart")
public class UploadFileMultipart {
	
	@POST
	@Path("/uploadMultipart")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadFileMultipart (
		@FormDataParam("file") InputStream uploadedInputStream,
		@FormDataParam("file") FormDataContentDisposition fileDetail) {
		
		System.out.println("1829-10");
 
		String uploadedFileLocation = "c://nat//tmp/" + fileDetail.getFileName();

		System.out.println("1829-20");
		
		// save it
		writeToFile(uploadedInputStream, uploadedFileLocation);
		System.out.println("1829-30");
 
		String output = "File uploaded to : " + uploadedFileLocation;
		System.out.println("1829-40");
 
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

package com.mkyong.rest;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/ReadFile")
public class ReadFile {
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String fileName) {

		StringBuilder sb = new StringBuilder();
		String output = "";
		try {
			// Open the file that is the first
			// command line parameter
			FileInputStream fstream = new FileInputStream("c:/tmp/"+fileName);
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			//Read File Line By Line
			while ((strLine = br.readLine()) != null)     {
				// Print the content on the console
				sb.append("<p>"+strLine);
				System.out.println(strLine);
			}
			//Close the input stream
			in.close();
		} catch (Exception e) {//Catch exception if any
			System.err.println("Error: " + e.getMessage());
			output = "could not open   "+fileName;
			return Response.status(200).entity(output).build();
		}
		output = sb.toString();

		return Response.status(200).entity(output).build();

	}
}

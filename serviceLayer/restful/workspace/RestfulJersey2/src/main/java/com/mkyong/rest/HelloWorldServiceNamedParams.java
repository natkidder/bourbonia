package com.mkyong.rest;
 
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
 
/* http://localhost:8080/RESTfulExample_Jersey1/rest/helloNamedParams/firstName/?name=bob   or
http://localhost:8080/RESTfulExample_Jersey1/rest/helloNamedParams/firstName  */

@Path("/helloNamedParams")
public class HelloWorldServiceNamedParams {
 
	@GET
	@Path("/{firstName}")
	public Response getMsg2(@DefaultValue("Jack") @QueryParam("name") String name) {
 
		String output = "Jersey say : " + name;
 
		return Response.status(200).entity(output).build();
 
	}
	
}
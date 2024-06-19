package com.mkyong.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import com.sun.research.ws.wadl.Request;
 
@Path("/user")
public class UserService {
 
	@POST
	@Path("/add")
 //   @Produces(MediaType.APPLICATION_XML)
 //   @Consumes(MediaType.APPLICATION_XML)
	@Produces("application/xml")
	@Consumes("application/xml")
	public Response addUser(
		@FormParam("name") String name,
		@FormParam("age") int age) {
 
		return Response.status(200)
			.entity("addUser is called, name : " + name + ", age : " + age)
			.build();
 
	}
	
	@POST
	@Path("/employee")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response getEmployee(Employee employee) {
	     employee.setEmployeeName(employee.getEmployeeName() + " Welcome");
	     return Response.status(Status.OK).entity(employee).build();
	}
	
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
 
		String output = "/user is : " + msg;
 
		return Response.status(200).entity(output).build();
 
	}
}

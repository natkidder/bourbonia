package org.tiaa.jersey.rest.client;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;
import java.util.regex.Pattern;

import com.sun.jersey.api.client.AsyncWebResource;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class GetClient {

	public GetClient()  {
		super();
	}
	
    public static void main(String[] args) {
    	if (args.length < 2)  {
    		System.out.println("arg1: which method # to call,   arg2: comma-delimited arguments");
    		System.exit(2);
    	}
    	int methodNumber = Integer.parseInt(args[0]);
    	String methodArgs = args[1];
    	if (methodNumber == 0) {
    		jerseySay(methodArgs);
    	} else if (methodNumber == 0)  {
    		readFile(methodArgs);
    	} else if (methodNumber == 1)  {
    		readFile(methodArgs);
    	} else if (methodNumber == 2)  {
    		jerseySayNamedParam(methodArgs);
    	} else if (methodNumber == 3)  {
    		jerseySayNamedParams(methodArgs);
    	}
    }

	private static void jerseySay(String name) {
        Client client = Client.create();
        WebResource resource = client.resource("http://localhost:8080/RestfulJersey2/rest/hello/" + name);
        String response = resource.get(String.class);
        AsyncWebResource asyncResource = client.asyncResource("http://localhost:8080/RESTfulExample_Jersey1/rest/hello/" + name);
        //TODO do something with asyncResource
        System.out.println(response);
	}
	
	// http://localhost:8080/Restful_Jersey2/rest/helloNamedParams2/fullName/?firstName=Bob&lastName=Feller
	private static void jerseySayNamedParam(String namedArgs) {
		List<String> args = Arrays.asList(namedArgs.split(","));
		String url = "http://localhost:8080/RestfulJersey2/rest/helloNamedParams/firstName";
		if (args.size() > 0) {
			url = url+"/?name="+args.get(0);
		}
		System.out.println(url);
        Client client = Client.create();
        WebResource resource = client.resource(url);
        String response = resource.get(String.class);
        AsyncWebResource asyncResource = client.asyncResource("");
        //TODO do something with asyncResource
        System.out.println(response);
	}
	
	// http://localhost:8080/Restful_Jersey2/rest/helloNamedParams2/fullName/?firstName=Bob&lastName=Feller
	private static void jerseySayNamedParams(String namedArgs) {
		List<String> args = Arrays.asList(namedArgs.split(","));
		String url = "http://localhost:8080/RestfulJersey2/rest/helloNamedParams2/fullName";
		Pattern pattern = Pattern.compile("^\\s*$");
		if (args == null || pattern.matcher(namedArgs).matches())  {
			url = url;
		} else if (args.size() == 1) {
			url = url+"/?firstName="+args.get(0);
		} else if (args.size() == 2)  {
			url = url+"/?firstName="+args.get(0)+"&lastName="+args.get(1);
		}
		System.out.println(url);
        Client client = Client.create();
        WebResource resource = client.resource(url);
        String response = resource.get(String.class);
        AsyncWebResource asyncResource = client.asyncResource("");
        //TODO do something with asyncResource
        System.out.println(response);
	}
	
	private static void readFile(String fileName) {
        Client client = Client.create();
        WebResource resource = client.resource("http://localhost:8080/RestfulJersey2/rest/ReadFile/" + fileName);
        String response = resource.get(String.class);
        System.out.println(response);
	}
}

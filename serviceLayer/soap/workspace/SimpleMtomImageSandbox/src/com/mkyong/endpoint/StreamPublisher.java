package com.mkyong.endpoint;

import javax.xml.ws.Endpoint;
import com.mkyong.ws.StreamServerImpl;
 
//Endpoint publisher
public class StreamPublisher{
 
    public static void main(String[] args) {
 
	Endpoint.publish("http://localhost:9999/sandbox/ws/stream", new StreamServerImpl());
 
	System.out.println("Server is published!");
 
    }
 
}
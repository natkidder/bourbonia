package com.javacodegeeks.enterprise.ws.jaxws;

import javax.xml.ws.Endpoint;

import com.javacodegeeks.enterprise.ws.jaxws.ImageServerImpl;
 
// run as a local Java application
public class ImageServerPublisher {
 
    public static void main(String[] args) {
       Endpoint.publish("http://localhost:9999/webservice/imageService", new ImageServerImpl());
    }
 
}

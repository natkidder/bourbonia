package com.javacodegeeks.enterprise.ws;
 
import javax.xml.ws.Endpoint;
import com.javacodegeeks.enterprise.ws.WebServiceImpl;
 
// run as a local Java application
public class WebServicePublisher {
 
    public static void main(String[] args) {
       Endpoint.publish("http://localhost:8080/webserive/helloworld", new WebServiceImpl());
    }
 
}

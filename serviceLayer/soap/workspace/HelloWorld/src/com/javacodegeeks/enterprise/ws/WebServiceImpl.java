package com.javacodegeeks.enterprise.ws;
 
import javax.jws.WebService;
 
@WebService(endpointInterface = "com.javacodegeeks.enterprise.ws.WebServiceInterface")
public class WebServiceImpl implements WebServiceInterface {
 
    @Override
    public String getHelloWorldAsString(String str) {
        return "Hello World of JAX-WS " + str;
    }
 
}

package com.javacodegeeks.enterprise.ws.jaxws;

import java.awt.Image;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
 
@WebService
@SOAPBinding(style = Style.RPC)
public interface ImageServerInterface {
 
    @WebMethod
    void downloadImage(String imageName, Image image);
 
    @WebMethod
    void uploadImage(Image imageToUpload, String returnStatus);
 
}


package com.javacodegeeks.enterprise.ws.jaxws;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
 
import javax.imageio.ImageIO;
import javax.jws.WebService;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.MTOM;

import org.apache.log4j.Logger;
 
@MTOM
@WebService(endpointInterface = "com.javacodegeeks.enterprise.ws.jaxws.ImageServerInterface")
public class ImageServerImpl implements ImageServerInterface{
 
	Logger log = Logger.getLogger(ImageServerImpl.class.getName());
	
    @Override
    public void downloadImage(String imageName, Image image) {
 
        log.info("1832-10 - imageName="+imageName);
        try {
 
            File imageFile = new File("c:\\tmp\\"+imageName);
            image = ImageIO.read(imageFile);
        
        } catch (IOException e) {
            e.printStackTrace(); 
        } catch (WebServiceException e)  {
        	e.printStackTrace();
        }
    }
 
    @Override
    public void uploadImage(Image imageToUpload, String returnStatus) throws WebServiceException {
 
        if(imageToUpload!=null){
 
            File imageFile = new File("C:\\tmp\\result.jpg");
            try {
            	log.info("0736-10");
                ImageIO.write(toBufferedImage(imageToUpload), "jpg", imageFile);
            } catch (IOException e) {
                e.printStackTrace();
                returnStatus = "Upload Failed-checked";
            }  
            returnStatus = "Upload Complete";
        } else {
        	throw new WebServiceException("Upload Failed-null value");
        }
 
       //throw new WebServiceException("Upload Failed-unchecked");
 
    }
 
    /**
     *  Utility to convert Image to BufferedImage in order to save it to a file
     *  From : https://code.google.com/p/game-engine-for-java/source/browse/src/com/gej/util/ImageTool.java#31
     */
    public static BufferedImage toBufferedImage(Image img)
    {
    	System.out.println("2051-10");
        if (img instanceof BufferedImage)
        {
            return (BufferedImage) img;
        }
 
        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
 
        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();
 
        // Return the buffered image
        return bimage;
    }
 
}

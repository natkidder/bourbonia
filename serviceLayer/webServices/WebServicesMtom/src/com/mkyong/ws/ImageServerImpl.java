package com.mkyong.ws;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;



import javax.imageio.ImageIO;
import javax.jws.WebService;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.MTOM;

//Service Implementation Bean
@MTOM
@WebService(endpointInterface = "com.mkyong.ws.ImageServer")
public class ImageServerImpl implements ImageServer{

	@Override
	public Image downloadImage(String name) {

		try {

			File image = new File("c:\\images\\" + name);
			return ImageIO.read(image);

		} catch (IOException e) {

			e.printStackTrace();
			return null; 

		}
	}

	@Override
	public String uploadImage(Image data) {

		if(data!=null){
			File imageFile = new File("C:\\images\\rss.png");
			try {
				ImageIO.write(toBufferedImage(data), "png", imageFile);
			} catch (IOException e) {
				e.printStackTrace();
				return "Upload Failed";
			} catch (WebServiceException wse)  {
				wse.printStackTrace();
				return "Upload Failed";
			}
		}
		return "Upload Complete";
	}

	/**
	 *  Utility to convert Image to BufferedImage in order to save it to a file
	 *  From : https://code.google.com/p/game-engine-for-java/source/browse/src/com/gej/util/ImageTool.java#31
	 */
	public static BufferedImage toBufferedImage(Image img)
	{
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

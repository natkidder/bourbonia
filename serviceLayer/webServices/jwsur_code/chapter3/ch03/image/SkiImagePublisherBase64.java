package ch03.image;

import javax.xml.ws.Endpoint;

public class SkiImagePublisherBase64 {
    public static void main(String[ ] args) {
      System.out.println("Publishing as ski on port 9876");	
      Endpoint.publish("http://127.0.0.1:9876/ski", new SkiImageService());
    }
}
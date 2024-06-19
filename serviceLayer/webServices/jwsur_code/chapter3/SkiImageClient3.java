import skiC3.SkiImageService_Service;
import skiC3.SkiImageService;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPBinding;
import java.util.List;
import java.io.IOException;
import javax.activation.DataHandler;

class SkiImageClient3 {
    public static void main(String[ ] args) {
       SkiImageService_Service service = new SkiImageService_Service();
       SkiImageService port = service.getSkiImageServicePort();

       DataHandler image = port.getImage("nordic");
       List<DataHandler> images = port.getImages();
       dump(image);
       for (DataHandler hd : images)
          dump(hd);
    }
    private static void dump(DataHandler dh) {
       System.out.println();
       try {
          System.out.println("MIME type: " + dh.getContentType());
          System.out.println("Content:   " + dh.getContent());
       }
       catch(IOException e) { System.err.println(e); }
    }
}
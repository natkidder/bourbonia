import skiC.SkiImageService_Service;
import skiC.SkiImageService;
import java.util.List;

class SkiImageClient {
    public static void main(String[ ] args) {
       // wsimport-generated artifacts
       SkiImageService_Service service = new SkiImageService_Service();
       SkiImageService port = service.getSkiImageServicePort();

       // Note the return types: byte[ ] and List<byte[ ]>
       byte[ ] image = port.getImage("nordic");
       List<byte[ ]> images = port.getImages();
       /* Transform the received bytes in some useful way :) */
    }
}

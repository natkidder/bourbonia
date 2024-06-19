package ch03.image;

import javax.xml.ws.Endpoint;
import javax.xml.ws.soap.SOAPBinding;
public class SkiImagePublisher {
    private Endpoint endpoint;

    public static void main(String[ ] args) {
        SkiImagePublisher me = new SkiImagePublisher();
        me.create_endpoint();
        me.configure_endpoint();
        me.publish();
    }

    private void create_endpoint() {
        endpoint = Endpoint.create(new SkiImageService());
    }

    private void configure_endpoint() {
        SOAPBinding binding = (SOAPBinding) endpoint.getBinding();
        binding.setMTOMEnabled(true);
    }

    private void publish() {
        int port = 9876;
        String url = "http://localhost:" + port + "/ski";
        endpoint.publish(url);
        System.out.println(url);
    }
}
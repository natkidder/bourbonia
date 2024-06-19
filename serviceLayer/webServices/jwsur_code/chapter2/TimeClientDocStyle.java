import client.TimeServerService;
import client.TimeServer;

class TimeClientDocStyle {
    public static void main(String[ ] args) {
       // The TimeServerService class is the Java type bound to
       // the service section of the WSDL document.
       TimeServerService service = new TimeServerService();

       // The TimeServer interface is the Java type bound to
       // the portType section of the WSDL document.
       TimeServer eif = service.getTimeServerPort();

       // Invoke the methods.
       System.out.println(eif.getTimeAsString());
       System.out.println(eif.getTimeAsElapsed());
    }
}

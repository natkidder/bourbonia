import clientSSL.EchoSSLService;
import clientSSL.EchoSSL;
import java.util.Map;
import javax.xml.ws.BindingProvider;

class EchoSSLClient {
    public static void main(String[ ] args) {
	final String endpoint = "https://localhost:8181/EchoSSLService/EchoSSL";
	try {
	    EchoSSLService service = new EchoSSLService();
	    EchoSSL port = service.getEchoSSLPort();

	    Map<String, Object> request_context = ((BindingProvider) port).getRequestContext();
	    request_context.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);

	    System.out.println(port.echo("Goodbye, cruel world!"));
	} 
	catch(Exception e) { System.err.println(e); }
    }
}  
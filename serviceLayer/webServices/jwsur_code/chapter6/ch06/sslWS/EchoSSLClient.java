import javax.xml.ws.WebServiceRef;
import clientSSL.EchoSSLService;
import clientSSL.EchoSSL;

class EchoSSLClient {
    @WebServiceRef(wsdlLocation = "https://localhost:8181/EchoSSLService/EchoSSL?wsdl")
    private EchoSSLService service;

    public static void main(String[ ] args) {
	new EchoSSLClient().do_it();
    }

    public void do_it() {
        try {
	    service = new EchoSSLService();
	    EchoSSL port = service.getEchoSSLPort();
            System.out.println(port.echo("Goodbye, cruel world!"));
        } 
	catch(Exception e) { System.err.println(e); }
    }
}





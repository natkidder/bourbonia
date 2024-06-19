package ch01.ts;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

import natsUtilities.NatsUtilities;

class TimeClient {
    private static final int START_PORT = 9800;
    private static final int END_PORT = 9900;
	
    public static void main(String args[ ]) throws Exception {
    	int port = NatsUtilities.getFreePort(START_PORT, END_PORT);
    	System.out.println("port="+port);
        URL url = new URL("http://localhost:"+port+"/ts?wsdl");

        // Qualified name of the service:
        //   1st arg is the service URI
        //   2nd is the service name published in the WSDL
        QName qname = new QName("http://ts.ch01/", "TimeServerImplService");

        // Create, in effect, a factory for the service.
        Service service = Service.create(url, qname);

        // Extract the endpoint interface, the service "port".
        TimeServer eif = service.getPort(TimeServer.class);

        System.out.println(eif.getTimeAsString());
        System.out.println(eif.getTimeAsElapsed());
   }
}

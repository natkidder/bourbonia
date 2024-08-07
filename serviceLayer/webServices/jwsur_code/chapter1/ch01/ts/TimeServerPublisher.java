package ch01.ts;

import javax.xml.ws.Endpoint;
import natsUtilities.NatsUtilities;

/**
 * This application publishes the Web service whose
 * SIB is ch01.ts.TimeServerImpl. For now, the service
 * service is published at network address 127.0.0.1.,
 * which is localhost, and at port number 9876, as this
 * port is likely available on any desktop machine. The
 * publication path is /ts, an arbitrary name.
 *
 * The Endpoint class has an overloaded publish method.
 * In this two-argument version, the first argument is the
 * publication URL as a string and the second argument is
 * an instance of the service SIB, in this case
 * ch01.ts.TimeServerImpl.
 *
 * The application runs indefinitely, awaiting service requests.
 * It needs to be terminated at the command prompt with control-C
 * or the equivalent.
 *
 * Once the applicatation is started, open a browser to the URL
 *
 *     http://127.0.0.1:9876/ts?wsdl
 *
 * to view the service contract, the WSDL document. This is an
 * easy test to determine whether the service has deployed
 * successfully. If the test succeeds, a client then can be
 * executed against the service.
*/
public class TimeServerPublisher {
    private static final int START_PORT = 9800;
    private static final int END_PORT = 9899;
    public static void main(String[ ] args) {
      // 1st argument is the publication URL
      // 2nd argument is an SIB instance
    	int port = NatsUtilities.getFreePort(START_PORT, END_PORT);
      Endpoint.publish("http://127.0.0.1:"+port+"/ts", new TimeServerImpl());
    }
}

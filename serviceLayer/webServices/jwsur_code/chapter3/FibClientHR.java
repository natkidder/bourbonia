import fibC.RabbitCounterService;
import fibC.RabbitCounter;
import fibC.UUIDHandler;
import fibC.TestHandler; 

import java.util.List;
import java.util.ArrayList;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

class FibClientHR {
    public static void main(String[ ] args) {
        RabbitCounterService service = new RabbitCounterService();
        service.setHandlerResolver(new ClientHandlerResolver());
        RabbitCounter port = service.getRabbitCounterPort();

        try {
           int n = 27;
           System.out.printf("fib(%d) = %d\n", n, port.countRabbits(n));
        }
        catch(Exception e) { System.err.println(e); }
    }
}
class ClientHandlerResolver implements HandlerResolver {
    public List<Handler> getHandlerChain(PortInfo port_info) {
        List<Handler> hchain = new ArrayList<Handler>();
        hchain.add(new UUIDHandler());
        hchain.add(new TestHandler()); // for illustration only: logical handler dumps messages to stdout
        return hchain;
    }
}

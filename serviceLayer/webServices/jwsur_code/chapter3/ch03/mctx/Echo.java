package ch03.mctx;

import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.jws.HandlerChain;

/** 
 * A minimalist service to explore the MessageContext.
 * The operation takes a string and echoes it together 
 * with transport information back to the client.
 */
@WebService
@HandlerChain(file = "handler-chain.xml")
public class Echo {
    // Enable 'dependency injection' on Web service context
    @Resource 
    WebServiceContext ws_ctx;

    @WebMethod
    public String echo(String from_client) {
	MessageContext ctx = ws_ctx.getMessageContext();

	//Map req_headers = (Map) ctx.get(MessageContext.HTTP_REQUEST_HEADERS);

	//dump_map((Map) ctx, "");
	String response = "Your message: " + from_client + "\n" +
	    "Message request headers: ";
	return response;
    }
    private void dump_map(Map map, String indent) {
	Set keys = map.keySet();
	for (Object key : keys) {
	    System.out.println(indent + key + " ==> " + map.get(key));
	    if (map.get(key) instanceof Map)
		dump_map((Map) map.get(key), indent += "   ");
	}
    }
}
 

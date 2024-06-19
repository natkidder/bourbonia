package ch03.image;

import java.util.Set;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.soap.SOAPException;
import java.io.IOException;

public class MessageDumper implements SOAPHandler<SOAPMessageContext> {
    public boolean handleMessage(SOAPMessageContext ctx) {
	Boolean request_p = (Boolean)
            ctx.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if (request_p) {
	    try {
		SOAPMessage msg = ctx.getMessage();
		msg.writeTo(System.out);
	    }
	    catch(SOAPException e) { System.err.println(e); }
	    catch(IOException e) { System.err.println(e); }
	}
        return true; 
    }
    public boolean handleFault(SOAPMessageContext ctx) { return true; }
    public Set<QName> getHeaders() { return null; }     
    public void close(MessageContext messageContext) { }
}

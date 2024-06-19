package fibC;

import javax.xml.ws.LogicalMessage;
import javax.xml.ws.handler.LogicalHandler;
import javax.xml.ws.handler.LogicalMessageContext;
import javax.xml.ws.handler.MessageContext;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;

public class ArgHandler implements LogicalHandler<LogicalMessageContext> {

    private static final String LoggerName = "ArgLogger";
    private Logger logger;
    private final boolean log_p = true; // set to false to turn off 

    public ArgHandler() { 
	logger = Logger.getLogger(LoggerName);
    }

    // If outgoing message argument is negative, make non-negative.
    public boolean handleMessage(LogicalMessageContext ctx) {

	Boolean outbound_p = (Boolean)
	    ctx.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
	if (outbound_p) {
	    if (log_p) logger.info("ArgHandler.handleMessage");
	    LogicalMessage msg = ctx.getMessage();

	    try {
		JAXBContext jaxb_ctx = JAXBContext.newInstance("fibC");
		Object payload = msg.getPayload(jaxb_ctx);
		if (payload instanceof JAXBElement) {
		    Object obj = ((JAXBElement) payload).getValue();
		    CountRabbits obj_cr = (CountRabbits) obj;
		    int n = obj_cr.getArg0();
		    if (n < 0){                      // negative argument?
			obj_cr.setArg0(Math.abs(n)); // make non-negative

			// Update the message by adding changed payload.
			((JAXBElement) payload).setValue(obj_cr);
			msg.setPayload(payload, jaxb_ctx);
		    }
		}
	    }
	    catch(JAXBException e) { }
	}
	return true;
    }  
    public boolean handleFault(LogicalMessageContext ctx) {
	return true;
    }    
    public void close(MessageContext ctx) { }
}

package ch05.wss;

import java.util.Set;
import java.util.HashSet;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
//import javax.xml.ws.WebServiceException;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.io.FileInputStream;
import java.io.File;
import com.sun.xml.wss.ProcessingContext;
import com.sun.xml.wss.SubjectAccessor;
import com.sun.xml.wss.XWSSProcessorFactory;
import com.sun.xml.wss.XWSSProcessor;
import com.sun.xml.wss.XWSSecurityException;

public class EchoSecurityHandler implements SOAPHandler<SOAPMessageContext> {
    private XWSSProcessor xwss_server = null;
    private boolean trace_p;

    public EchoSecurityHandler() {
	XWSSProcessorFactory fact = null;
	try {
	    fact = XWSSProcessorFactory.newInstance();
	}
	catch(XWSSecurityException e) { throw new RuntimeException(e); }

	FileInputStream config = null;

        try {
	    config =  new FileInputStream(new File("META-INF/server.xml"));
	    xwss_server = 
		fact.createProcessorForSecurityConfiguration(config, new Verifier());
	    config.close();
	}
	catch (Exception e) { throw new RuntimeException(e); }
	trace_p = true; // set to true to enable message dumps
    }
   
    public Set<QName> getHeaders() {
	String uri = "http://docs.oasis-open.org/wss/2004/01/" +
	    "oasis-200401-wss-wssecurity-secext-1.0.xsd";
	QName security_hdr = new QName(uri, "Security", "wsse");
	HashSet<QName> headers = new HashSet<QName>();
	headers.add(security_hdr);
	return headers;
    } 

    public boolean handleMessage(SOAPMessageContext msg_ctx) {
        Boolean outbound_p = (Boolean)       
	    msg_ctx.get (MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        SOAPMessage msg = msg_ctx.getMessage();
	
	if (!outbound_p.booleanValue()) {
	    // Validate the message.
            try{
                ProcessingContext p_ctx =  xwss_server.createProcessingContext(msg);
                p_ctx.setSOAPMessage(msg);
                SOAPMessage verified_msg = null;
                verified_msg= xwss_server.verifyInboundMessage(p_ctx);

		System.out.println(SubjectAccessor.getRequesterSubject(p_ctx));

                msg_ctx.setMessage(verified_msg);

		if (trace_p) dump_msg("Incoming message:", verified_msg);
            } 
	    catch (XWSSecurityException e) { throw new RuntimeException(e); }
            catch(Exception e) { throw new RuntimeException(e); }
        }
	return true;
    }   

    public boolean handleFault(SOAPMessageContext msg_ctx) { return true; }
    public void close(MessageContext msg_ctx) { }

    private void dump_msg(String msg, SOAPMessage soap_msg) {
	try {
	    System.out.println(msg);
	    soap_msg.writeTo(System.out);
	    System.out.println();
	}
	catch(Exception e) { throw new RuntimeException(e); }
    }
}

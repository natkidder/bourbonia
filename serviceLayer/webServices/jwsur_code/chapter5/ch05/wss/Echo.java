package ch05.wss;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.xml.ws.Binding;
import javax.xml.ws.handler.Handler;
import com.sun.xml.wss.SubjectAccessor;
import javax.xml.ws.WebServiceContext;
import javax.annotation.Resource;
import com.sun.xml.wss.XWSSecurityException;

@WebService
public class Echo {
    @Resource 
    WebServiceContext ws_ctx;

    @WebMethod
    public String echo(String msg) {
	String ret_val = null;
	try {
	    ret_val = 
		msg + ": " +  SubjectAccessor.getRequesterSubject(ws_ctx);
	}
	catch(XWSSecurityException e) { throw new RuntimeException(e); }
	return ret_val;
    }
}


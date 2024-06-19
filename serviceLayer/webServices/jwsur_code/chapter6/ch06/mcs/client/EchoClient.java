package ch06.mcs.client;

import java.io.PrintWriter;
import java.io.IOException;
import java.io.Closeable;
import javax.annotation.Resource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import javax.xml.ws.soap.SOAPFaultException;

public class EchoClient extends HttpServlet {
    @WebServiceRef(wsdlLocation = "http://localhost:8081/echoMCS/EchoService?wsdl")
    public EchoService service;

    public void doGet(HttpServletRequest req, HttpServletResponse res) {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try {
            out = res.getWriter();

	    // Grab the context path and the user's message.
	    String ctx_path = 
		(req.getContextPath() != null) ? req.getContextPath() : "echoClient";
            out.println("<h3>EchoServlet: " + ctx_path + "</h3>");

	    String arg = 
		(req.getParameter("msg") != null) ? req.getParameter("msg") : "Hi!";

	    // Get the port reference and invoke echo method.
	    service = new EchoService();
            Echo port = service.getEchoPort();
            String result = port.echo(arg);

            // If there's no SOAP fault so far, authentication worked.
            out.println("<h3>Authentication OK</h3><br/>");
            out.println(result);
            out.flush();
            ((Closeable) port).close(); // close connection to service
        }
        catch (SOAPFaultException e) {
            out.println("Authentication failure: " + e);
        }
        catch (Exception e) { out.println(e); }
        finally { out.close(); }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) {
        try {
            this.doGet(req, res); // shouldn't happen but just in case :)
        }
        catch(Exception e) { throw new RuntimeException("doPost"); }
    }
}

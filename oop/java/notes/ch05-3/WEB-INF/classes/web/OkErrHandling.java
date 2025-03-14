/* Beginning J2EE p. 187 try-catch Exception Handling */
package web;

import java.io.*;
import javax.servlet.http.*;

public class OkErrHandling extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<html><body>");
		try  {
			String nbr = request.getParameter("number");
			Integer i = new Integer(nbr);
			writer.println("You entered the number " + i.intValue());
			writer.println("</body></html>");
			writer.close();
		} catch (Exception x)  {
			log("Did not enter a number", x);
			writer.println("You must enter a number");
		}
	}
}

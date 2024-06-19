/* Beginning J2EE p. 187 Deployment Descriptor Exception Handling */

package web;

import java.io.*;
import javax.servlet.http.*;

public class ErrorPageErrHandling extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<html><body>");
		String nbr = request.getParameter("number");
		Integer i = new Integer(nbr);
		writer.println("You entered the number " + i.intValue());
		writer.println("</body></html>");
		writer.close();
	}
}

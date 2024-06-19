package web;

import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class GetSession extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		try {
			response.setContentType("text/html");
			PrintWriter writer = response.getWriter();
			writer.println("<html><body>");

			if (session == null)  {  // you have already created the session, so it's not null
				writer.println("You are not logged in");
			} else {
				writer.println("<h3>Thank you, you are already logged in.  Here is the data for your session:</h3>");
				Enumeration names = session.getAttributeNames();
				while ( names.hasMoreElements() )  {
					String name = (String) names.nextElement();
					Object value = session.getAttribute(name);
					writer.println("<p>name=" + name + " value=" + value);
				}
			}
			writer.println("<p><a href=\"/ch05-5/login.html\">Return</a> to Login page");
			writer.println("</body></html>");
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			log("", e);
		}
	}
}


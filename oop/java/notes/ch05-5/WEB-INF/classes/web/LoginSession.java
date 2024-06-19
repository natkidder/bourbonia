package web;

import javax.servlet.http.*;
import java.io.*;

public class LoginSession extends HttpServlet {
	public void doPost( HttpServletRequest request, HttpServletResponse response)  {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		HttpSession session = request.getSession(true);
		session.setAttribute("username", username);
		session.setAttribute("password", password);

		try  {
			response.setContentType("text/html");
			PrintWriter writer = response.getWriter();
			writer.println("<html><body>");
			writer.println("<p>Thank you, " + username + ", you are now logged in");
			String newURL = response.encodeURL("/ch05-5/GetSession");
			writer.println("<p>Click <a href=\"" + newURL + "\">here</a> for another servlet");
			writer.println("</body></html>");
			writer.close();
		} catch (Exception e) {
			log("", e);
		}
	}
}

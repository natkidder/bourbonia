/* CMW, p. 179, illustrates thread-unsafe servlet */

package web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class LoginTUS extends HttpServlet {
	private String username;
	private String password;
	private String sleeptime;
	private int sleep;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)  {
		/* This variables are local to the method.  Because they have the same name as the instance variables, they hide the
		   instance variables inside the method */
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		/* Here we use the keyword 'this'.  By using such a keyword, we can access the instance variable of the class */
		this.username = username; // the instance created first gets these set by those created second
		this.password = password;

		try  {
			this.sleeptime = getInitParameter("sleep.time"); // ref's the web.xml sleep.time param-name and returns its param-value
			this.sleep = Integer.parseInt(sleeptime);
			Thread.sleep(this.sleep);
		} catch(Exception e) {
			log("", e);
		}

		try  {
			response.setContentType("text/html");
			PrintWriter writer = response.getWriter();
			writer.println("<html><body>");
			writer.println("<p>LOCAL doPost METHOD");
			writer.println("<p>username=" + username);
			writer.println("<p>password=" + password);
			writer.println("<p>SERVLET INSTANCE VARIABLES");
			writer.println("<br>username=" + this.username);
			writer.println("<br>password=" + this.password);
			writer.println("<p><p>slept for " + sleeptime + " milliseconds");
			writer.println("</body></html>");
			writer.close();
		} catch(Exception e)  {
			e.printStackTrace();
		}
	}
}

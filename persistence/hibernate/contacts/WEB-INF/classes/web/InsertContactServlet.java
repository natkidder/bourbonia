package web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class InsertContactServlet extends HttpServlet  {

	public void doPost(HttpServletRequest request, HttpServletResponse response)  {
		response.setContentType("text/html");
		try {
			PrintWriter writer = response.getWriter();
			String result = "";  //InsertContact.InsertSingle();
			writer.println("<html><body>");
			writer.println("Results: " + result);
			writer.println("</html></body>");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)  {
		this.doPost(request, response);
	}
}

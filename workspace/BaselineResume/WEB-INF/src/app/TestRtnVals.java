package app;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class TestRtnVals extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		runServlet(req, resp);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		runServlet(req, resp);
	}
	public void runServlet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter pw = resp.getWriter();
		pw.print("<html><body>");
		pw.print("sent to client");
		String fname = req.getParameter("firstName"); pw.print("<p> ");
		pw.print("first name: " + fname + " "); pw.print("<p> ");
		Enumeration enum1 = req.getParameterNames();
		while (enum1.hasMoreElements())   {
			String pname = (String) enum1.nextElement();
			String[] pvalues = req.getParameterValues(pname);
			pw.print("Name [" + pname + "] values: ");
			for (int i=0; i<pvalues.length; i++)  {
				pw.print(pvalues[i]);
			}
			pw.println("<br>");
		}
		pw.print("</body></html>");
	}
}

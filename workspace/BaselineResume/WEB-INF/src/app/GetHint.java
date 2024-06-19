package app;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class GetHint extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;  // innoculates against certain errors

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			      throws java.io.IOException {
			  String q = req.getParameter("q");
			  String match = "";

			  if (q != null) {
				int len=q.length();
				Set<String> names = createNames(req);
				for (String name : names)  {
					if (name.length() > len)  {
						if (name.substring(0, len).equalsIgnoreCase(q)) {
							match += name + " ";
						}
					}
				}
			  }

			  // Write text to response
//			  res.setContentType("text/html");  // this would generate an entire page
			  res.getWriter().write(match);
			}
	public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws java.io.IOException {
		doPost(req, res);
	}
	
	public Set createNames(HttpServletRequest req)  {
		Set<String> names = new HashSet<String>();
		HttpSession userSession = req.getSession();
		Integer i = Integer.parseInt(userSession.getAttribute("0").toString()); 
		for (Integer j=1; j<=i; j++)  {
			names.add((String) userSession.getAttribute(j.toString()));
		}
		return names;
	}
}

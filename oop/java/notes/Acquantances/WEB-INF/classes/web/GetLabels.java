package web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.logging.Logger;
import java.util.*;

public class GetLabels extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)  {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		response.setContentType("text/html");
		String fname;
		String lname;
		String mi;
		String street;
		String street2;
		String city;
		String state;
		String zip;
		String hphone;
		String dphone;
		String email;
		String spouse;
		String comments;

		try  {
			PrintWriter writer = response.getWriter();
			ArrayList<Acquantance> acqs = JDBCClient.createAcqs(username, password);
			Acquantance acq;
			Iterator iter = acqs.iterator();
			while(iter.hasNext()) {
				acq = (Acquantance)iter.next();
				fname = acq.getFname();
				lname = acq.getLname();
				mi = acq.getMi();
				street = acq.getStreet();
				street2 = acq.getStreet2();
				city = acq.getCity();
				state = acq.getState();
				zip = acq.getZip();
				hphone = acq.getHphone();
				dphone = acq.getDphone();
				email = acq.getEmail();
				spouse = acq.getSpouse();
				comments = acq.getComments();

				writer.println("<html><body>");
				writer.println("<br>" + fname + " " + mi + " " + lname);
				writer.println("<br>" + street);
				if (!street2.equals("")) { writer.println("<br>" + street2); }
				writer.println("<br>" + city + ", " + state + " " + zip);
				writer.println("<p>" + comments);
				writer.println("<p><p><p>");
				writer.println("</body></html>");
			}
			writer.close();
		} catch(IOException e) {
			e.printStackTrace();
		} catch(Exception e)  {
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)  {
		this.doPost(request, response);
	}
}

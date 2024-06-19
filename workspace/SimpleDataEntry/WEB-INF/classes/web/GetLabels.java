package web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.logging.Logger;
import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class GetLabels extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)  {
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
			writer.println("<html><body>");
			List acqs = RunQuery.getAddresses();
			if (acqs != null)  {
				Iterator iter = acqs.iterator();
				Acquantance acq;
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
					hphone = acq.getHomePhone();
					dphone = acq.getDayPhone();
					email = acq.getEmail();
					spouse = acq.getSpouse();
					comments = acq.getComments();

					if (fname == null) { fname = ""; }
					if (lname == null) { lname  = "";}
					if (mi == null) { mi  = "";}
					if (street == null) { street  = "";}
					if (street2 == null) { street2  = "";}
					if (city == null) { city  = "";}
					if (state == null) { state  = "";}
					if (zip == null) { zip  = "";}
					if (hphone == null) { hphone  = "";}
					if (dphone == null) { dphone  = "";}
					if (email == null) { email  = "";}
					if (spouse == null) { spouse  = "";}
					if (comments == null) { comments  = "";}
					
					writer.println("<br>" + fname + " " + mi + " " + lname);
					writer.println("<br>" + street);
					if (!street2.equals("")) { writer.println("<br>" + street2); }
					writer.println("<br>" + city + ", " + state + " " + zip);
					if (hphone.length() > 0 || dphone.length() > 0 || email.length() > 0)    {
						writer.println("<p>(H) "+hphone+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(D) "+dphone+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;email: "+email);	
					}
					writer.println("<p>" + comments);
					writer.println("<p>====================<p><p>");
				}
			}
			writer.println("</body></html>");
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

package web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.logging.Logger;
import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class GetPerson extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)  {

		try  {
			Acquantance ad = new Acquantance();
			ad.setFname("Homer");
			ad.setLname("Simpson");
		} catch(Exception e)  {
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)  {
		this.doPost(request, response);
	}
}

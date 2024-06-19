package web;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.logging.Logger;
import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class RefreshDatabase extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)  {
		response.setContentType("text/html");

		try  {
			PrintWriter writer = response.getWriter();
            ApplicationContext ctx = new ClassPathXmlApplicationContext("web/acq-ann-context.xml");
            AcqDao acqDao = (AcqDao) ctx.getBean("acqDao");
			writer.println("<html><body>");
			//acqDao.deletePeople();
			//writer.println("<br>Removed all acquantances");
			acqDao.addPerson();
			writer.println("<br>Added new acquantances");
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

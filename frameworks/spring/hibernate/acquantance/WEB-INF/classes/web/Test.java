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

public class Test {

	public static void main (String[] args)  {
		try  {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("web/acq-ann-context.xml");
        	AcqDao acqDao = (AcqDao) ctx.getBean("acqDao");
			System.out.println("<html><body>");
			acqDao.deletePeople();
			System.out.println("<br>Removed all acquantances");
			acqDao.addPeople();
			System.out.println("<br>Added new acquantances");
			System.out.println("</body></html>");
		} catch(Exception e)  {
			e.printStackTrace();
		}
	}
}

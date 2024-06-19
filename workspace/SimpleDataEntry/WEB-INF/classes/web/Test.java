package web;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
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
			acqDao.deletePerson("Lexi", "Barrington");
			System.out.println("<br>Removed all acquantances");
			acqDao.addPerson();
			System.out.println("<br>Added one acquantance");
			acqDao.addPerson();
			System.out.println("<br>Added new acquantances");
			List<Acquantance> results = acqDao.getPeople();
			if (results != null)  {
				for (ListIterator i = results.listIterator(); i.hasNext(); )  {
					Acquantance acq = (Acquantance)i.next();
					System.out.println("Acquantance: " + acq.getFname() + " " + acq.getLname());
				}
			} else {
				System.out.println("no results");
			}
			System.out.println("</body></html>");
		} catch(Exception e)  {
			e.printStackTrace();
		}
	}
}

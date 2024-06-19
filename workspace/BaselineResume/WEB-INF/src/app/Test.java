package app;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.logging.Logger;
import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.apache.struts.action.*;

public class Test {

	public static void main (String[] args)  {
/*
			ApplicationContext ctx = new ClassPathXmlApplicationContext("app/resume-xml-context.xml");
        	ResumeDao resumeDao = (ResumeDao) ctx.getBean("resumeDao");
			System.out.println("<html><body>");

			resumeDao.deleteResumes();
			System.out.println("<br>Removed all resumes");
			resumeDao.addResume();
			System.out.println("<br>Added new resume");
			System.out.println("</body></html>");
*/
//		TestHibernateQuery thQuery = new TestHibernateQuery();
//		thQuery.queryResume();
		TestHibernateInsert thInsert = new TestHibernateInsert();
		thInsert.insertResume();
//		System.out.println("done inserting");
	}

}

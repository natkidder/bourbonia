package web;

import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class UpdateContact  {

	public static void main(String args[])  {
		Configuration config = new AnnotationConfiguration();
		config.configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Contact contact = new Contact();
			Query query = session.getNamedQuery("filterByFname");
			query.setString("fname", "Andy");
			List list = query.list();
			System.out.println(list.size()); ////
			for (ListIterator iter = list.listIterator(); iter.hasNext(); )  {
				contact = (Contact)iter.next();
				contact.setStreet("123 Applewood Ln.");
				session.save(contact);
			}
		} catch (Exception e)  {
			if (tx != null)  {
				tx.rollback();
			}
			session.close();
			e.printStackTrace();
		} finally  {
			if (tx != null)  {
				tx.commit();
			}
			session.close();
		}
		sessionFactory.close();
	}
}

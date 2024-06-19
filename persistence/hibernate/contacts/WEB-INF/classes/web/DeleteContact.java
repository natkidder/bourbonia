package web;

import java.util.*;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.AnnotationConfiguration;

public class DeleteContact {

	public static void main(String[] args)  {
		Configuration config = new AnnotationConfiguration();
		config.configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try  {
			Contact contact = new Contact();
			tx = session.beginTransaction();
			Query query = session.getNamedQuery("filterByFname");
			query.setString("fname","Barry");
			List list = query.list();
			for (ListIterator iter = list.listIterator(); iter.hasNext();)  {
				contact = (Contact)iter.next();
				session.delete(contact);
			}
			tx.commit();
		} catch (Exception e)  {
			if (tx != null)  {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		sessionFactory.close();
	}
}

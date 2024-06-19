package web;

import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class RunInsert2 {
	
	public static void doInsert(List<Acquantance> acqs)  {
		Acquantance acq;
		Configuration config = new AnnotationConfiguration();
		config.configure();

		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Iterator iter = acqs.iterator();
			while (iter.hasNext())  {
				acq = (Acquantance) iter.next();
				session.save(acq);
			}
			tx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		sessionFactory.close();
	}
}

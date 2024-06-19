package web;

import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class RunInsert {
	
	public static void doInsert(String fname)  {
		Configuration config = new AnnotationConfiguration();
		config.configure();

		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Acquantance acq = new Acquantance(Salutation.MR, fname, "Q", "Smith", "13 Maple Ave.", "", "River Heights", "OH", "44236", "211-555-1234", "", "240-555-7676", "jqd@mailstop.com", "Jane Doe", "test");
			session.save(acq);
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

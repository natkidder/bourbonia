package web;

import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class RunQuery  {

	public static List list;

	public static List getAddresses()  {
		if (list != null) { list.clear(); }
		Configuration config = new AnnotationConfiguration();
		config.configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();

		try {
			Query query = session.getNamedQuery("web.fname");
			query.setText("fname","Andy");
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
			if (list != null) { list.clear(); }
		} finally {
			session.close();
			sessionFactory.close();
			return list;
		}
	}

	public static Acquantance moveFwd(ListIterator iter) {
		if (iter == null)  {
			return new Acquantance();
		} else {
			return (Acquantance)iter.next();
		}
	}
}
		

package app;

import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class TestHibernateQuery {
	public void queryResume() {
        Configuration config = new AnnotationConfiguration();
        config.configure();
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        List list;
        try {
                Query query = session.getNamedQuery("app.getResume");
                //query.setText("fname","Andy");
                list = query.list();
                for (ListIterator iter = list.listIterator(); iter.hasNext(); )  {
                	Object[] row = (Object[])iter.next();
                	String firstName = (String)row[0];
                	String lastName = (String)row[1];
                	Date birthDt = (Date)row[2];
                	System.out.println(firstName + "," + lastName + "," + birthDt.toString());
                }
        } catch (Exception e) {
                e.printStackTrace();
        } finally {
                session.close();
                sessionFactory.close();
        }            
	}
}

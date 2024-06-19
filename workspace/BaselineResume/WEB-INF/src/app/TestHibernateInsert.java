package app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.math.*;

public class TestHibernateInsert {
	
	public void insertResume() {
		Configuration config = new Configuration();
		config.configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Resume resumeChild = new Resume();
			
            resumeChild.setFirstName( "f" ) ;
            resumeChild.setMi( "m" ) ;
            resumeChild.setLastName( "l" ) ;
            resumeChild.setCurrEmployed( "yes" ) ;
            resumeChild.setStreet( "s" ) ;
            resumeChild.setApt( "a" ) ;
            resumeChild.setCity( "c" ) ;
            resumeChild.setState( "s" ) ;
            resumeChild.setZip( "z" ) ;
            resumeChild.setHphone( "h" ) ;
            resumeChild.setOphone( "o" ) ;
            resumeChild.setCphone( "c" ) ;
            resumeChild.setWorkCity( "wc" ) ;
            resumeChild.setWorkState( "ws" ) ;
            resumeChild.setEmail( "e" ) ;
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            Date date = df.parse("1/1/1970");
            resumeChild.setBirthDt( date ) ;
            resumeChild.setGender( "F" ) ;
            resumeChild.setLowSalary( new BigDecimal("4.0") ) ;
            resumeChild.setHighSalary( new BigDecimal("9.0") ) ;
            resumeChild.setRelocation( "yes" ) ;
            resumeChild.setComments( "comments" ) ;
            resumeChild.setSkill( "skill" ) ;
            resumeChild.setYearsExp( Integer.parseInt("3") ) ;
            
//            Resume resume = (Resume)resumeChild;
            
            session.save(resumeChild);
            tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			try {
				if (session != null)  {
					session.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		sessionFactory.close();
	
	}
}

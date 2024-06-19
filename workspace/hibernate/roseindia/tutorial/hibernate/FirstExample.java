
package roseindia.tutorial.hibernate;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Deepak Kumar
 *
 * http://www.roseindia.net
 * Hibernate example to insert data into Contact table
 */
public class FirstExample {
	public static void main(String[] args) {
		Session session = null;


			// This step will read hibernate.cfg.xml and prepare hibernate for use
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			 session = sessionFactory.openSession();
			Transaction tx = null;
			try{
				tx = session.beginTransaction();
				//Create new instance of Contact and set values in it by reading them from form object
			 	System.out.println("Inserting Record");
				Contact contact = new Contact();
				contact.setId(6);
				contact.setFirstName("Deepak");
				contact.setLastName("Kumar");
				contact.setEmail("deepak_38@yahoo.com");
				session.save(contact);
				System.out.println("Done");
				tx.commit();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			// Actual contact insertion will happen at this step
			session.flush();
			session.close();

			}
		
	}
}

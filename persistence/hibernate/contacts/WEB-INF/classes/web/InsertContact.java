package web;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.AnnotationConfiguration;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
//import javax.persistence.*;  // allows the @<annotation> elements
import java.io.Serializable;

public class InsertContact {

//	public static String InsertSingle()  {
	public static void main(String[] args) {
		StringBuffer diagnostics = new StringBuffer();
		Calendar currCal = Calendar.getInstance();
		Calendar varCal = Calendar.getInstance();
		Configuration config = new AnnotationConfiguration();
		config.configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try  {
			Contact contact;
			tx = session.beginTransaction();
			varCal.set(2009,7,10);
			contact = new Contact( Salutation.MR, "Andy", "Doe", "123 Aspen St.", "River Heights", "OH", "44236", "Midwest", "USA", "Drew Law Firm", "Law Clerk", "222-555-work", "x519", "222-555-cell", "222-555-home", "222-555-facs", "jdoe@drew.com", varCal.getTime(), ContactCategory.ICC, "Bess Marvin", "Likes Hannah's Cooking", 5, currCal.getTime(), "Carson's Assisting Attorney", new ArrayList<Encounter>()); 
			varCal.set(2009,10,23);
			contact.getEncounters().add(new Encounter(varCal.getTime(), "Climbed an aspen")); 
			varCal.set(2009,10,24);
			contact.getEncounters().add(new Encounter(varCal.getTime(), "Discovered a hidden panel in the office")); 
			session.save(contact); 
			contact = new Contact( Salutation.MR, "Barry", "Doe", "123 Birch St.", "River Heights", "OH", "44236", "Midwest", "USA", "Drew Law Firm", "Law Clerk", "222-555-work", "x519", "222-555-cell", "222-555-home", "222-555-facs", "jdoe@drew.com", varCal.getTime(), ContactCategory.ICC, "Bess Marvin", "Likes Hannah's Cooking", 5, currCal.getTime(), "Carson's Assisting Attorney", new ArrayList<Encounter>()); 
			varCal.set(2009,10,23);
			contact.getEncounters().add(new Encounter(varCal.getTime(), "Climbed a birch")); 
			session.save(contact); 
			contact = new Contact( Salutation.MR, "Carl", "Doe", "123 Conifer St.", "River Heights", "OH", "44236", "Midwest", "USA", "Drew Law Firm", "Law Clerk", "222-555-work", "x519", "222-555-cell", "222-555-home", "222-555-facs", "jdoe@drew.com", varCal.getTime(), ContactCategory.ICC, "Bess Marvin", "Likes Hannah's Cooking", 5, currCal.getTime(), "Carson's Assisting Attorney", new ArrayList<Encounter>()); 
			varCal.set(2009,10,23);
			contact.getEncounters().add(new Encounter(varCal.getTime(), "Climbed a conifer")); 
			session.save(contact); 
			contact = new Contact( Salutation.MR, "David", "Doe", "123 Dogwood St.", "River Heights", "OH", "44236", "Midwest", "USA", "Drew Law Firm", "Law Clerk", "222-555-work", "x519", "222-555-cell", "222-555-home", "222-555-facs", "jdoe@drew.com", varCal.getTime(), ContactCategory.ICC, "Bess Marvin", "Likes Hannah's Cooking", 5, currCal.getTime(), "Carson's Assisting Attorney", new ArrayList<Encounter>()); 
			varCal.set(2009,10,23);
			contact.getEncounters().add(new Encounter(varCal.getTime(), "Planted a dogwood")); 
			session.save(contact); 

		} catch (Exception e)  {
			if (tx != null)  {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			tx.commit();
			session.close();
		}
		sessionFactory.close();
	}
}
/*
salutation
fname
lname
street
city

state
postalCode
region
country
companyName

title
workPhone
workExt
cellPhone
homePhone
faxNbr

email
lastMeetingDt
contactCategory
referredBy
notes

importance
lastUpdated
relationship
transactions
*/

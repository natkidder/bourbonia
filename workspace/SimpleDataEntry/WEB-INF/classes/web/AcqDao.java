package web;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.READ_COMMITTED)
public class AcqDao  {

	public AcqDao() {}

	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate)  {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional(readOnly=true)
	public List<Acquantance> getPeople()  {
		List<Acquantance> results = hibernateTemplate.find("from Acquantance acq where not acq.fname = '' and not acq.lname = '' and not acq.street = '' order by acq.lname");
		return results.size() > 0 ? results : null;
	}

	@Transactional(timeout=30)
	public void addPerson()  {
		Acquantance acq = new Acquantance();
		acq.setFname("Martin");
		acq.setLname("van Buren");
		hibernateTemplate.save(acq);
	}


	@Transactional(timeout=300)
	public void addPerson(Acquantance acq)  {
		ArrayList<Acquantance> acqs = new ArrayList<Acquantance>();
		acqs.add(acq);
		hibernateTemplate.saveOrUpdateAll(acqs);
	}

	@Transactional(timeout=90)
	public void updPeople(String fname, String lname) {
		List<Acquantance> results = hibernateTemplate.find("from Acquantance acq where acq.fname = '"+fname+"' and acq.lname='"+lname+"'");
		System.out.println(this.getClass().getSimpleName()+".updPeople - results.size="+results.size()); ////
		for (Acquantance acq : results)  {
			acq.setStreet("6363 Walker Lane");
			acq.setStreet2("");
			acq.setCity("Alexandria");
			acq.setState("VA");
			acq.setZip("22310");
			//acq.setHomePhone("608-781-4246");
			hibernateTemplate.update(acq);
		}
	}
	
	@Transactional(timeout=90)
	public int deletePerson(String fname, String lname) {
		List<Acquantance> results = hibernateTemplate.find("from Acquantance acq where acq.fname = '"+fname+"' and acq.lname='"+lname+"'");
		System.out.println("Number of people to delete: " + results.size());  ////
		hibernateTemplate.deleteAll(results);
		return results.size();
	}
	

}

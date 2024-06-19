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
		List<Acquantance> results = hibernateTemplate.find("from Acquantance acq where acq.fname is not null and acq.lname is not null and acq.street is not null");
		return results.size() > 0 ? results : null;
	}

	@Transactional(timeout=30)
	public void addPerson()  {
		Acquantance acq = new Acquantance();
		acq.setFname("Fred");
		acq.setLname("Barnett");
		hibernateTemplate.save(acq);
	}

	@Transactional(timeout=300)
	public void addPeople()  {
		Acquantance acq;
		List<Acquantance> acqs = JDBCClient.createAcqs("nkidder","wlypb");
//		System.out.println("To insert: " + acqs.size());  ////
//		RunInsert2.doInsert(acqs);
		hibernateTemplate.saveOrUpdateAll(acqs);
/*
		Iterator iter = acqs.iterator();
		while (iter.hasNext()) {
			acq = (Acquantance) iter.next();
			System.out.println(acq.toString());
			System.out.println(acq.getId());
			hibernateTemplate.save(acq);
		}
*/
	}

	@Transactional(timeout=90)
	public void deletePeople() {
		List<Acquantance> results = hibernateTemplate.find("from Acquantance");
//		System.out.println("To delete: " + results.size());  ////
		hibernateTemplate.deleteAll(results);
	}
}

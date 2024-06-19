package web;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import java.util.List;

public class AcqDaoHibernateDaoSupport extends HibernateDaoSupport  {

	public AcqDaoHibernateDaoSupport() {}

	public Acquantance findPerson(String fname, String lname)  {
		List results = getHibernateTemplate().find("FROM acquantances WHERE f_name = ? and l_name = ?", new Object[] {fname, lname});
		return results.size() > 0 ? (Acquantance) results.get(0) : new Acquantance();
	}
}

package web;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

import java.util.*;

public class RunQuery  {

	public static List<Acquantance> list;

	public static List getAddresses()  {
		if (list != null) { list.clear(); }

		ApplicationContext ctx = new ClassPathXmlApplicationContext("web/acq-ann-context.xml");
        AcqDao acqDao = (AcqDao) ctx.getBean("acqDao");

        list = acqDao.getPeople();
		return list != null ? list : null;
	}

/*
	public static Acquantance moveFwd(ListIterator iter) {
		if (iter == null)  {
			return new Acquantance();
		} else {
			return (Acquantance) iter.next();
		}
	}
*/		
}

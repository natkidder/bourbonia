package web;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public class Test2 {

	public static void main(String args[])  {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("web/acq-ann-context.xml");

		AcqDaoHibernateDaoSupport adhds = (AcqDaoHibernateDaoSupport) ctx.getBean("acqDaoHDS");
		Acquantance acq = adhds.findPerson("Elizabeth", "Ambler");
		System.out.println( acq.toString() );
	}
}

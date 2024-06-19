package jdbc;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public class Test {

	public static void main(String args[])  {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc/jdbc-context.xml");

		RetrieveAcq rtrAcq = (RetrieveAcq) ctx.getBean("retrieveAcq");
		Acquantance acq = rtrAcq.getAcq("Elizabeth", "Ambler");
		System.out.println( acq.toString() );
	}
}

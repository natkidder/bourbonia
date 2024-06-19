package com.springinaction.springidol2;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public class Test  {

	public static void main(String[] args) throws PerformanceException {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/springinaction/springidol/spring-idol.xml");

		Performer performer = (Performer) ctx.getBean("duke");
		performer.perform();

		performer = (Performer) ctx.getBean("kenny");
		performer.perform();

		performer = (Performer) ctx.getBean("johnny");
		performer.perform();
	}
}

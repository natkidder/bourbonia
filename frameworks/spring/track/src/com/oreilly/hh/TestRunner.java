package com.oreilly.hh;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
* A simple harness to run our test;  Configures Log4j, creates an application context, retrieves a bean from Spring
*/
public class TestRunner  {
	private static Logger log;

	public static void main(String[] args)  {
		try {
			PropertyConfigurator.configure(TestRunner.class.getResource("/log4j.properties"));
			log = Logger.getLogger(TestRunner.class);

			// Load our Spring application context
			log.info("Initializing TestRunner ...");
			log.info("Loading Spring Configuration ...");
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

			// Retrieve the test name from the command line and run the test
			String testName = args[0];
			log.info("Running test: " + testName);
			Test test = (Test) context.getBean(testName);
			test.run();
		} catch (Exception e)  {
			log.info(e.getMessage());
		}
	}
}

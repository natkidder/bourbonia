package com.mkyong;

import java.io.File;
import java.io.IOException;

import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.*;



/*@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = {
"classpath:spring/batch/jobs/job-report.xml",
"classpath:spring/batch/config/context.xml",
"classpath:xml/report.xml",
"classpath:src/resources"})*/

public class App {
	
	public static void main(String[] args) throws IOException  {
		// make the parent to the path a source folder in build path
/*		String testFilePath = "spring/batch/config/context.xml"; 
		File file = new File(testFilePath);
		System.out.println("file "+testFilePath+" "+file.exists());
		org.springframework.core.io.Resource r = new ClassPathResource(testFilePath);
		System.out.println(r.getURI().getPath());
		System.out.println(testFilePath+" exists: "+r.exists());*/

		String[] springConfig  = 
			{	
				"spring/batch/config/context.xml",
				"spring/batch/jobs/job-report.xml" 
			};

		ApplicationContext context = 
				new ClassPathXmlApplicationContext(springConfig);

		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		Job job = (Job) context.getBean("reportJob");

		try {

			JobExecution execution = jobLauncher.run(job, new JobParameters());
			System.out.println("Exit Status : " + execution.getStatus());
			System.out.println("look at cvs/report.csv");

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Done");

	}
}
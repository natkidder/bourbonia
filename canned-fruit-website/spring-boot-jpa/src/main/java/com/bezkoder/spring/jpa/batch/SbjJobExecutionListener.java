package com.bezkoder.spring.jpa.batch;

import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.annotation.AfterJob;
import org.springframework.batch.core.annotation.BeforeJob;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;
import org.springframework.batch.item.ExecutionContext;

@Configuration
public class SbjJobExecutionListener implements JobExecutionListener {

	//@BeforeJob
	public void beforeJob(JobExecution jobExecution) {
		System.out.println("Job is about to start for Job ID: " + jobExecution.getJobId() + "    "+jobExecution.getJobInstance().getJobName());
		ExecutionContext execContext = jobExecution.getExecutionContext();
		for (Entry entry : execContext.entrySet()) {
			System.out.println(entry.getKey().toString()+ "   "+entry.getValue().toString());
		}
	}

	//@AfterJob
	public void afterJob(JobExecution jobExecution) {
		System.out.println("Job has completed with status: " + jobExecution.getStatus());
	}
}

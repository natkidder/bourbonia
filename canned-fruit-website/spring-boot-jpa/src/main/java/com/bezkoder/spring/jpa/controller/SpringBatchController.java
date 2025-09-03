package com.bezkoder.spring.jpa.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/batch")
@Component
public class SpringBatchController {
    @Autowired
    public JobLauncher jobLauncher;
    
//    @Autowired
//    private JobLauncher jobLauncher2;

    @Autowired
    @Qualifier("mediumDocJob")
    public Job mediumDocJob;

    @Autowired
    @Qualifier("distinctFruitDocJob")
    public Job distinctFruitDocJob;

    @GetMapping("/mediumDoc")
    public ResponseEntity<String> handle() {
        try {
			JobParameters jobParameters = new JobParametersBuilder()
			    .addLong("time", System.currentTimeMillis()) // Add unique parameter to ensure new job instance
			    .toJobParameters();
			jobLauncher.run(mediumDocJob, jobParameters);
			return new ResponseEntity("mediumDocJob batch job complete...", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
    }

    @GetMapping("/distinctFruitDoc")
    public ResponseEntity<String> handleDistinctFruit()  {
    	try {
			System.out.println("running handleDistinctFruit ..."); ///////
			JobParameters jobParameters = new JobParametersBuilder()
			    .addLong("time", System.currentTimeMillis()) // Add unique parameter to ensure new job instance
			    .toJobParameters();
			JobExecution jobExecution = jobLauncher.run(distinctFruitDocJob, jobParameters);
			String jobName = jobExecution.getJobInstance().getJobName();
			return new ResponseEntity(jobName + "  batch job complete...", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
    }
}

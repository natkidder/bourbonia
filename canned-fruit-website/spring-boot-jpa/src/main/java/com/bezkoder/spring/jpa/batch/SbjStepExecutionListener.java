package com.bezkoder.spring.jpa.batch;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class SbjStepExecutionListener implements StepExecutionListener {
    @Override
    public void beforeStep(StepExecution stepExecution) {
        System.out.println("Step started at: " + stepExecution.getStartTime());
        System.out.println("Step Job name is: "+ stepExecution.getJobExecution().getJobInstance().getJobName());
        System.out.println("Step name is: "+stepExecution.getStepName());
        // Add any setup or logic before the step starts
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        System.out.println("Step finished at: " + stepExecution.getEndTime());
        // Add any cleanup or logic after the step completes
        return null; // Return null to use the default ExitStatus
    }

}

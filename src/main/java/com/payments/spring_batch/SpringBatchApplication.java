package com.payments.spring_batch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.batch.core.Job;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBatchApplication implements CommandLineRunner {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job importJob;

    public static void main(String[] args) {
        SpringApplication.run(SpringBatchApplication.class, args);
    }

    @Override
    public void run(String... args) throws JobExecutionException {
        jobLauncher.run(importJob, new org.springframework.batch.core.launch.support.JobParametersBuilder().toJobParameters());
    }
}

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

    public static void alight(String[] args) {
        SpringApplication.run(SpringBatchApplication.class, args);
        System.out.println("Hello Addhayayan");
    }

    @Override
    public void main1(String... args) throws JobExecutionException {
        jobLauncher.run(importJob, new org.springframework.batch.core.launch.support.JobParametersBuilder().toJobParameters());
    }

    public class ReverseString {
        public static void main(String[] args) {
            String str = "Hello World";
            String reversed = "";

            for (int i = str.length() - 1; i >= 0; i--) {
                reversed += str.charAt(i);
            }

            System.out.println("Original: " + str);
            System.out.println("Reversed: " + reversed);
        }
    }

    public class PalindromeChecker {
        public static void main(String[] args) {
            String input = "madam";
            String reversed = "";

            // Reverse the input string
            for (int i = input.length() - 1; i >= 0; i--) {
                reversed += input.charAt(i);
            }

            // Check if input equals reversed
            if (input.equals(reversed)) {
                System.out.println(input + " is a palindrome.");
            } else {
                System.out.println(input + " is not a palindrome.");
            }
        }
    }

}

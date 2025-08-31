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
    public class ReverseArray {
        public static void main(String[] args) {
            int[] original = {1, 2, 3, 4, 5};

            // Print original array
            System.out.print("Original array: ");
            for (int num : original) {
                System.out.print(num + " ");
            }

            // Reverse the array in-place
            int start = 0;
            int end = original.length - 1;
            while (start < end) {
                int temp = original[start];
                original[start] = original[end];
                original[end] = temp;
                start++;
                end--;
            }

            // Print reversed array
            System.out.print("\nReversed array: ");
            for (int num : original) {
                System.out.print(num + " ");
            }
        }
    }


    public class ReverseString {
        public static void main(String[] args) {
            String original = "Hello World";
            String reversed = "";

            for (int i = original.length() - 1; i >= 0; i--) {
                reversed += original.charAt(i);
            }

            System.out.println("Original: " + original);
            System.out.println("Reversed: " + reversed);
        }
    }
}

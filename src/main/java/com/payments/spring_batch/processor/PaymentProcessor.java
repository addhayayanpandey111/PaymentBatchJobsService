package com.payments.spring_batch.processor;
import org.springframework.batch.item.ItemProcessor;
import com.payments.spring_batch.model.PaymentRecord;

public class PaymentProcessor implements ItemProcessor<PaymentRecord, PaymentRecord> {

    @Override
    public PaymentRecord process(PaymentRecord item) throws Exception {
        if (item.getAmount() > 1000) {
            item.setStatus("High");
        } else {
            item.setStatus("Low");
        }
        return item;
    }

    public int getNumber(String num){
        if(num.equals("One")){
            return 1;
        }
        return 0;
    }
    public int getNumberThree(String num){
        if(num.equals("Three")){
            return 1;
        }
        return 0;
    }


    public static void main1(String mychanges) {
        // Test the method with different email strings
        String email1 = "test@example.com";
        String email2 = "invalid-email.com";
        try {
            // Parse the date string into a Date object
            Date parsedDate = sdf.parse(dateString);

            // Print the parsed Date object
            System.out.println("Parsed Date: " + parsedDate);
        } catch (Exception e) {
            // Handle parsing errors
            System.out.println("Error parsing date: " + e.getMessage());
        }finally {
            System.out.println("Inside finally block");
        }
        System.out.println(isValidEmail(email1));
        System.out.println(isValidEmail(email2));
        System.out.println("Nisha");
        System.out.println("Addhayayan");
    }
}

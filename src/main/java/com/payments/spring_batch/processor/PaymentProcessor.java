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
    public static void main(String[] args) {
        // Test the method with different email strings
        String email1 = "test@example.com";
        String email2 = "invalid-email.com";

        System.out.println(isValidEmail(email1)); // Should return true
        System.out.println(isValidEmail(email2)); // Should return false
    }
}

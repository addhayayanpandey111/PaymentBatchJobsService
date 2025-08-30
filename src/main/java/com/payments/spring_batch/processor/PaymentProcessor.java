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


    public static void (String mychanges) {
        System.out.println(isValidEmail(email1));
        System.out.println(isValidEmail(email2));
    }
}

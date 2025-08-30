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
        if(num.equals("Two")){
            return 2;
        }
        return 0;
    }
}

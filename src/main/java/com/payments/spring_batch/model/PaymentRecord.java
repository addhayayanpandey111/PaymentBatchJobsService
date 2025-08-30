package com.payments.spring_batch.model;

import lombok.Data;

@Data
public class PaymentRecord {

    private String id;
    private double amount;
    private String status;
}

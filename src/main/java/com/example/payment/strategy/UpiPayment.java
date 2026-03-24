package com.example.payment.strategy;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class UpiPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("UPI Payment: ₹" + amount);
    }
}
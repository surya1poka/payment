package com.example.payment.strategy;

import org.springframework.stereotype.Component;

@Component
public class CardPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Card Payment: ₹" + amount);
    }
}
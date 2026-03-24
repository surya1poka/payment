package com.example.payment.service;

import org.springframework.stereotype.Service;

import com.example.payment.strategy.PaymentMethod;

@Service
public class PaymentService {

    public String processPayment(PaymentMethod method, double amount) {

        if (authorize()) {
            debit(amount);
            method.pay(amount);
            return "Payment Successful: Rs " + amount;
        } else {
            return "Payment Failed";
        }
    }

    private boolean authorize() {
        System.out.println("Authorizing...");
        return true;
    }

    private void debit(double amount) {
        System.out.println("Debiting Rs " + amount);
    }
}
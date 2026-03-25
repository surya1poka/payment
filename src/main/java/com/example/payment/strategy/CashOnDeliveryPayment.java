package com.example.payment.strategy;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class CashOnDeliveryPayment implements PaymentMethod {

    // Runs after bean creation
    @PostConstruct
    public void init() {
        System.out.println("COD Service Initialized ✅");
    }

    @Override
    public void pay(double amount) {
        System.out.println("Cash on Delivery: Rs " + amount);
    }

    // Runs before application shutdown
    @PreDestroy
    public void destroy() {
        System.out.println("COD Service Destroyed ❌");
    }
}
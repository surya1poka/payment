package com.example.payment.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.payment.service.PaymentService;
import com.example.payment.strategy.PaymentMethod;

@Component
public class PaymentManager {

    @Autowired
    private PaymentMethod defaultPayment; // UPI (Primary)

    @Autowired
    @Qualifier("netBanking")
    private PaymentMethod netBanking;

    @Autowired
    private PaymentService service;

    public void runPayments() {

        double amount = 500; // default amount

        System.out.println("---- Default Payment (UPI) ----");
        System.out.println(service.processPayment(defaultPayment, amount));

        System.out.println("\n---- NetBanking Payment ----");
        System.out.println(service.processPayment(netBanking, amount));
    }
}
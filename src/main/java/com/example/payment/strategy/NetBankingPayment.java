package com.example.payment.strategy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("netBanking")
public class NetBankingPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("NetBanking Payment: ₹" + amount);
    }
}
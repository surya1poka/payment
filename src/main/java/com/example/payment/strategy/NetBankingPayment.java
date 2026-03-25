package com.example.payment.strategy;

import org.springframework.stereotype.Component;

@Component("netBanking") 
public class NetBankingPayment implements PaymentMethod {

    public NetBankingPayment() {
        System.out.println("NetBanking Bean Created ");
    }

    @Override
    public void pay(double amount) {
        System.out.println("NetBanking Payment: Rs " + amount);
    }
}
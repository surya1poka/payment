package com.example.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.payment.manager.PaymentManager;

@SpringBootApplication
public class PaymentApplication implements CommandLineRunner {

    @Autowired
    private PaymentManager manager;

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class, args);
    }

    @Override
    public void run(String... args) {
        manager.runPayments();
    }
}
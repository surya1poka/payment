package com.example.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.payment.service.PaymentService;
import com.example.payment.strategy.CardPayment;
import com.example.payment.strategy.CashOnDeliveryPayment;
import com.example.payment.strategy.NetBankingPayment;
import com.example.payment.strategy.PaymentMethod;
import com.example.payment.strategy.UpiPayment;

@RestController
@CrossOrigin
public class PaymentController {

    @Autowired
    private PaymentService service;

    @Autowired
    private UpiPayment upi;

    @Autowired
    private CardPayment card;

    @Autowired
    private CashOnDeliveryPayment cod;

    @Autowired
    @Qualifier("netBanking")
    private NetBankingPayment netBanking;

    @PostMapping("/pay")
public String pay(@RequestParam(required = false) String method,
                  @RequestParam(required = false) Double amount) {

    if (method == null || amount == null || amount <= 0) {
        return "Invalid Input ❌";
    }

    PaymentMethod selected;

    switch (method.toLowerCase()) {
        case "upi":
            selected = upi;
            break;
        case "card":
            selected = card;
            break;
        case "netbanking":
            selected = netBanking;
            break;
        case "cod":
            selected = cod;
            break;    
        default:
            return "Invalid Payment Method ❌";
    }

    return service.processPayment(selected, amount);
}
}
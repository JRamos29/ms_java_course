package com.jramos29.hr_payroll.services;

import org.springframework.stereotype.Service;

import com.jramos29.hr_payroll.entities.Payment;

@Service
public class PaymentService {

    public Payment getPayment(long workerId, Integer days) {
        return new Payment("Bob", 200.0, days);
    }
}

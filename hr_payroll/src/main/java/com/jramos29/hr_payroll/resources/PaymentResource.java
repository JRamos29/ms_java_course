package com.jramos29.hr_payroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jramos29.hr_payroll.entities.Payment;
import com.jramos29.hr_payroll.services.PaymentService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

    private static final String HR_WORKER = "hr-worker";

    @Autowired
    private PaymentService service;

    @GetMapping(value = "/{workerId}/days/{days}")
    @CircuitBreaker(name = HR_WORKER, fallbackMethod = "getPaymentFallback")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
        Payment payment = service.getPayment(workerId, days);

        return ResponseEntity.ok(payment);
    }

    public ResponseEntity<String> getPaymentFallback(Exception e) {
        return ResponseEntity.ok("hr-worker service is down: " + e.getMessage());
    }
}

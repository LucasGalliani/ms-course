package com.lucasgalliani.hr_payroll.controller;

import com.lucasgalliani.hr_payroll.entity.Payment;
import com.lucasgalliani.hr_payroll.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days){

        logger.info("Requisição recebida na instância da porta: {} | workerId: {} | days: {}", serverPort, workerId, days);

        Payment payment = paymentService.getPayment(workerId, days);

        logger.info("Resposta gerada para workerId: {} na instância da porta: {}", workerId, serverPort);

        return ResponseEntity.ok(payment);
    }

}

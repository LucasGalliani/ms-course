package com.lucasgalliani.hr_payroll.service;

import com.lucasgalliani.hr_payroll.entity.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(Long workerId,int days){

        return new Payment("Lucas",100.0,days);
    }
}

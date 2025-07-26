package com.lucasgalliani.hr_payroll.service;

import com.lucasgalliani.hr_payroll.entity.Payment;
import com.lucasgalliani.hr_payroll.entity.Worker;
import com.lucasgalliani.hr_payroll.feignclients.WorkerFeignClient;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(Long workerId, int days) {
        try {
            Optional<Worker> workerOptional = workerFeignClient.findById(workerId).getBody();

            if (workerOptional == null || workerOptional.isEmpty()) {
                throw new RuntimeException("Worker não encontrado para o ID: " + workerId);
            }

            Worker worker = workerOptional.get();

            return new Payment(worker.getName(), worker.getDailyInCome(), days);

        } catch (FeignException e) {
            throw new RuntimeException("Erro na comunicação com o serviço de workers: " + e.getMessage(), e);
        }
    }
}

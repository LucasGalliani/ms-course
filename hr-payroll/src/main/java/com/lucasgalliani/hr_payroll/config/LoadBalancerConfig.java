package com.lucasgalliani.hr_payroll.config;

import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.List;

@Configuration
public class LoadBalancerConfig {

    @Bean
    public ServiceInstanceListSupplier serviceInstanceListSupplier() {
        return new ServiceInstanceListSupplier() {
            @Override
            public String getServiceId() {
                return "hr-worker";
            }

            @Override
            public Flux<List<ServiceInstance>> get() {
                List<ServiceInstance> instances = List.of(
                        new DefaultServiceInstance("worker1", "hr-worker", "localhost", 8001, false),
                        new DefaultServiceInstance("worker2", "hr-worker", "localhost", 8002, false)
                );
                return Flux.just(instances);
            }
        };
    }
}

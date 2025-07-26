package com.lucasgalliani.hr_payroll.config;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

import java.net.URI;
import java.util.List;

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
                return Flux.just(List.of(
                        new ServiceInstance() {
                            @Override
                            public String getServiceId() {
                                return "hr-worker";
                            }

                            @Override
                            public String getHost() {
                                return "localhost";
                            }

                            @Override
                            public int getPort() {
                                return 8001;
                            }

                            @Override
                            public boolean isSecure() {
                                return false;
                            }

                            @Override
                            public URI getUri() {
                                return URI.create("http://localhost:8001");
                            }

                            @Override
                            public java.util.Map<String, String> getMetadata() {
                                return java.util.Collections.emptyMap();
                            }
                        },
                        new ServiceInstance() {
                            @Override
                            public String getServiceId() {
                                return "hr-worker";
                            }

                            @Override
                            public String getHost() {
                                return "localhost";
                            }

                            @Override
                            public int getPort() {
                                return 8002;
                            }

                            @Override
                            public boolean isSecure() {
                                return false;
                            }

                            @Override
                            public URI getUri() {
                                return URI.create("http://localhost:8002");
                            }

                            @Override
                            public java.util.Map<String, String> getMetadata() {
                                return java.util.Collections.emptyMap();
                            }
                        }
                ));
            }
        };
    }
}

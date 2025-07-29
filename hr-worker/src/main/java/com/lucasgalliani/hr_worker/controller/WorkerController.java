package com.lucasgalliani.hr_worker.controller;

import com.lucasgalliani.hr_worker.entity.Worker;
import com.lucasgalliani.hr_worker.service.WorkerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/workers")
@RefreshScope
public class WorkerController {

    private static final Logger logger = LoggerFactory.getLogger(WorkerController.class);

    @Value("${test.config}")
    private String testConfig;

    @Autowired
    private WorkerService workerService;

    @Autowired
    private Environment env;

    @GetMapping("/configs")
    public ResponseEntity<Void> getConfig(){
        logger.info("CONFIG: " + testConfig);
        return ResponseEntity.noContent().build();
    }


    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){

        return workerService.findByAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Worker>> findById(@PathVariable Long id) throws InterruptedException {
        return workerService.findById(id);
    }
}

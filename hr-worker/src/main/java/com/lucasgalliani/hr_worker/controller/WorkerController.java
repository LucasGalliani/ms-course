package com.lucasgalliani.hr_worker.controller;

import com.lucasgalliani.hr_worker.entity.Worker;
import com.lucasgalliani.hr_worker.service.WorkerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class WorkerController {


    private Logger logger = LoggerFactory.getLogger(WorkerController.class);

    @Autowired
    private Environment env;

    @Autowired
    private WorkerService workerService;


    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){

        return workerService.findByAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Worker>> findById(@PathVariable Long id) {

        logger.info("PORT= " + env.getProperty("local.server.port"));

        return workerService.findById(id);
    }

}

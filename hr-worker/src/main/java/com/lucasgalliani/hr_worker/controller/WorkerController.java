package com.lucasgalliani.hr_worker.controller;

import com.lucasgalliani.hr_worker.entity.Worker;
import com.lucasgalliani.hr_worker.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/workes")
public class WorkerController {

    @Autowired
    private WorkerService workerService;


    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){

        return workerService.findByAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Worker>> findById(@PathVariable Long id) {

        return workerService.findById(id);
    }

}

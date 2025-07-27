package com.lucasgalliani.hr_worker.service;


import com.lucasgalliani.hr_worker.entity.Worker;
import com.lucasgalliani.hr_worker.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository workerRepository;


    public ResponseEntity<List<Worker>> findByAll(){

        List<Worker> workerList = workerRepository.findAll();

        return ResponseEntity.ok(workerList);

    }


    public ResponseEntity<Optional<Worker>> findById(Long id) throws InterruptedException {


        Optional<Worker> worker = workerRepository.findById(id);

        return ResponseEntity.ok(worker);
    }
}

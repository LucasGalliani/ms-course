package com.lucasgalliano.hr_user.controller;

import com.lucasgalliano.hr_user.entity.User;
import com.lucasgalliano.hr_user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RefreshScope
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {

        User obj = userRepository.findById(id).get();
        System.out.println("ID: " + id);

        return ResponseEntity.ok(obj);

    }

    @GetMapping("/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {

        User obj = userRepository.findByEmail(email);

        return ResponseEntity.ok(obj);

    }
}

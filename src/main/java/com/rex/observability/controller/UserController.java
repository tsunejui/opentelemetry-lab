package com.rex.observability.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rex.observability.models.User;
import com.rex.observability.repository.UserRedisRepository;
import com.rex.observability.repository.UserRepository;

@RestController
public class UserController {

    Logger logger = LoggerFactory.getLogger(GreetingController.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRedisRepository userRedisRepository;

    @GetMapping("/user")
    public ResponseEntity<?> list() {
        logger.info("Get Users");
        List<User> users  = userRepository.findAll();
        userRedisRepository.saveAll(users);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/user")
    public ResponseEntity<?> save(@RequestBody User user) {
        logger.info("Get Users");
        userRepository.save(user);
        userRedisRepository.save(user);
        return ResponseEntity.ok(null);
    }
    
}

package com.tech.demoExcepption.controller;

import com.tech.demoExcepption.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @GetMapping("/{id}")
    public String getUserById(@PathVariable Long id){
        // Simulate user retrieval
        if (id <= 0 || id > 10){
            throw new ResourceNotFoundException("User Not Found with Id: " + id);
        }
        return "User " + id;
    }
}

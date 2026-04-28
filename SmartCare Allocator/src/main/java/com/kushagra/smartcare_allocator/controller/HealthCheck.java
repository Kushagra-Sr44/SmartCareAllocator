package com.kushagra.smartcare_allocator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HealthCheck {
    @GetMapping
    public ResponseEntity<?> printHello(Authentication auth){
        return new ResponseEntity<>(auth.getName()+ "hello", HttpStatus.OK);
    }
}

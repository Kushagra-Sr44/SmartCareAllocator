package com.kushagra.smartcare_allocator.controller;

import com.kushagra.smartcare_allocator.entity.User;
import com.kushagra.smartcare_allocator.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user){
        return userService.createUser(user);

    }
}

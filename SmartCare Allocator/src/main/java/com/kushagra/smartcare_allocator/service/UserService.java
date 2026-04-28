package com.kushagra.smartcare_allocator.service;

import com.kushagra.smartcare_allocator.entity.User;
import com.kushagra.smartcare_allocator.repository.UserRepository;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public ResponseEntity<?> createUser(User user) {
        if (userRepository.findByuserName(user.getUserName()) != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        String role = user.getRole();
        if (!role.equals("ADMIN") && !role.equals("PATIENT") && !role.equals("DOCTOR"))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

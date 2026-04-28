package com.kushagra.smartcare_allocator.controller;

import com.kushagra.smartcare_allocator.entity.Doctor;
import com.kushagra.smartcare_allocator.repository.DoctorRepository;
import com.kushagra.smartcare_allocator.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @GetMapping
    public ResponseEntity<?> getDoctor(Authentication auth){
        return doctorService.getDoctor(auth);
    }
    @PutMapping
    public ResponseEntity<?> updateDoctor(Authentication auth, @RequestBody Doctor doctor){
        return doctorService.editDoctor(auth,doctor);
    }
    @DeleteMapping
    public  ResponseEntity<?> deleteDoctor(Authentication auth){
        return doctorService.deleteDoctor(auth);
    }
}

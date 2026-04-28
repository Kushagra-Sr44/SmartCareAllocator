package com.kushagra.smartcare_allocator.controller;

import com.kushagra.smartcare_allocator.entity.*;
import com.kushagra.smartcare_allocator.service.DoctorService;
import com.kushagra.smartcare_allocator.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PatientService patientService;
    @PostMapping("/doctor")
    public ResponseEntity<?> createDoctor(@RequestBody Doctor doctor){
        return doctorService.addDoctor(doctor);
    }
    @PostMapping
    public ResponseEntity<?> createPatient(@RequestBody Patient patient){
        return patientService.createPatient(patient);
    }
}

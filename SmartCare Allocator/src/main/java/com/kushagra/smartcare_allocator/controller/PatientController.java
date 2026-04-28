package com.kushagra.smartcare_allocator.controller;
import com.kushagra.smartcare_allocator.entity.Patient;
import com.kushagra.smartcare_allocator.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;
@GetMapping
    public ResponseEntity<?> getPatientDetails(Authentication auth) {
    return patientService.getPatientDetails(auth);
}

@PutMapping
    public ResponseEntity<?> editPatientDetails(Authentication auth,@RequestBody Patient patient){
    return  patientService.editPatientDetails(auth,patient);
}
@DeleteMapping
    public ResponseEntity<?> deletePatient(Authentication auth){
    return  patientService.deletePatient(auth);
}
}

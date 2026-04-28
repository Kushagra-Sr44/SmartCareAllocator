package com.kushagra.smartcare_allocator.service;

import com.kushagra.smartcare_allocator.entity.Patient;
import com.kushagra.smartcare_allocator.repository.PatientRepository;
import com.kushagra.smartcare_allocator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;
 @Autowired
 private UserRepository userRepository;
    public ResponseEntity<?> createPatient( Patient patient) {
        if(patientRepository.findByname(patient.getName())!=null)
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        patientRepository.save(patient);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    public ResponseEntity<?> getPatientDetails(Authentication auth) {
        Patient patient = patientRepository.findByname(auth.getName());
        if (patient == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }
    @Transactional
    public ResponseEntity<?> deletePatient(Authentication auth){
        patientRepository.deleteByname(auth.getName());
        userRepository.deleteByuserName(auth.getName());
        return new ResponseEntity<>(HttpStatus.OK);
    }
    public ResponseEntity<?>  editPatientDetails(Authentication auth,Patient patient){
        Patient oldpatient=patientRepository.findByname(auth.getName());
        if(oldpatient==null)return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        patient.setPatientId(oldpatient.getPatientId());
        patientRepository.save(patient);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

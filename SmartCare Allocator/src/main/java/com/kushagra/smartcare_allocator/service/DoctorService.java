package com.kushagra.smartcare_allocator.service;

import com.kushagra.smartcare_allocator.entity.Doctor;
import com.kushagra.smartcare_allocator.entity.User;
import com.kushagra.smartcare_allocator.repository.DoctorRepository;
import com.kushagra.smartcare_allocator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DoctorService  {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private UserRepository userRepository;
    public ResponseEntity<?> addDoctor(Doctor doctor){
        String name=doctor.getName();
        if(!doctorRepository.findByname(name).isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        doctorRepository.save(doctor);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    public ResponseEntity<?> getDoctor(Authentication auth){
        String name=auth.getName();
        if(!doctorRepository.findByname(name).isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Doctor doctor=doctorRepository.findByname(name).get();
        return new ResponseEntity<>(doctor,HttpStatus.OK);
    }
    @Transactional
    public ResponseEntity<?> editDoctor(Authentication auth,Doctor doctor){
        String name=auth.getName();
        if(!doctorRepository.findByname(name).isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        doctorRepository.deleteByname(doctor.getName());
        doctorRepository.save(doctor);
        return new ResponseEntity<>(HttpStatus.OK);

    }
    @Transactional
    public ResponseEntity<?> deleteDoctor(Authentication auth){
        String name=auth.getName();
        if(!doctorRepository.findByname(name).isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Doctor doctor=doctorRepository.findByname(auth.getName()).get();
        doctorRepository.deleteByname(name);
        List<User> list=userRepository.findAll();
        for(User user:list){
            if(user.getUserName().equals(auth.getName())&& user.getRole().equals("DOCTOR")) {
                userRepository.deleteByuserName(auth.getName());
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

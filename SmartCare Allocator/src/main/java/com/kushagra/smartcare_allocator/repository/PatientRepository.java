package com.kushagra.smartcare_allocator.repository;

import com.kushagra.smartcare_allocator.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Integer> {
    public Patient findByname(String name);
     public void deleteByname(String name);
}

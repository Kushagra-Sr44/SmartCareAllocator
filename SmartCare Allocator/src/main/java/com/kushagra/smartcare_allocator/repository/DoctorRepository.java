package com.kushagra.smartcare_allocator.repository;

import com.kushagra.smartcare_allocator.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    public Optional<Doctor> findByname(String name);
    public void deleteByname(String name);
}

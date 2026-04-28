package com.kushagra.smartcare_allocator.repository;

import com.kushagra.smartcare_allocator.entity.Bed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BedRepository extends JpaRepository<Bed,Integer> {
}

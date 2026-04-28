package com.kushagra.smartcare_allocator.repository;
import com.kushagra.smartcare_allocator.entity.BedAllocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BedAllocationRepository extends JpaRepository<BedAllocation,Integer> {
}

package com.kushagra.smartcare_allocator.repository;

import com.kushagra.smartcare_allocator.entity.ResourceAllocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceAllocationRepository  extends JpaRepository<ResourceAllocation,Integer> {
}

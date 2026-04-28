package com.kushagra.smartcare_allocator.repository;

import com.kushagra.smartcare_allocator.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource,Integer> {
}

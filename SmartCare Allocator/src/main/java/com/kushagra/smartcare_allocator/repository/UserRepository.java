package com.kushagra.smartcare_allocator.repository;

import com.kushagra.smartcare_allocator.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByuserName(String username);
    public void deleteByuserName(String username);


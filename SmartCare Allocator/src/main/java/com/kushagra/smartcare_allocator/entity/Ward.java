package com.kushagra.smartcare_allocator.entity;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
public class Ward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ward_id")
    private  int wardId;
    @Column(name="ward_name")
    private String name;
    private int capacity;

}

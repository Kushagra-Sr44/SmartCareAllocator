package com.kushagra.smartcare_allocator.entity;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rsid")
    private int rsId;
    private String type;
    private String status;
    private String name;


}

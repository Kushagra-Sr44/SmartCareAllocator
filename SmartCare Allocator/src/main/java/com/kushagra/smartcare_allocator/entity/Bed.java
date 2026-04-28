package com.kushagra.smartcare_allocator.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Bed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="bed_id")
    private int bedId;
    @Column(name="bed_no")
    private int bedNo;
    private String status;
    @OneToOne
    @JoinColumn(name="ward_id")
    private Ward ward;

}

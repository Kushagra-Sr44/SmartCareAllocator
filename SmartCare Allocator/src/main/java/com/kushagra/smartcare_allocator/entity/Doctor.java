package com.kushagra.smartcare_allocator.entity;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name="doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="doctor_id")
    private int doctorId;

    private String name;
    private String specialization;
}

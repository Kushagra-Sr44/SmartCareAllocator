package com.kushagra.smartcare_allocator.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name="patient_id")
    private int patientId;
    private String name;
    private String gender;
    @Column(name="contact_no")
    private String contactNo;
    private String disease;
    private LocalDate dob;
@ManyToOne
@JoinColumn(name ="doctor_id")
    private Doctor doctor;
}

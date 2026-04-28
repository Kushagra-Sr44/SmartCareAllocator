package com.kushagra.smartcare_allocator.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
@Table(name = "bed_allocation")
public class BedAllocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="abid")
    private int abId;

    @ManyToOne
    @JoinColumn(name="patient_id")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name="bed_id")
    private Bed bed;
    @Column(name="admission_date")
    private LocalDate admissionDate;
    @Column(name="discharge_date")
    private LocalDate dischargeDate;
}

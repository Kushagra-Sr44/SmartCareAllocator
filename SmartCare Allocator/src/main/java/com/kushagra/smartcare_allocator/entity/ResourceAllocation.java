package com.kushagra.smartcare_allocator.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="resource_allocation")
public class ResourceAllocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="arsid")
    private int arsId;
    @ManyToOne
    @JoinColumn(name="rsid")
    private Resource resource;
    @ManyToOne
    @JoinColumn(name="patient_id")
    private Patient patient;
    @Column(name="start_date")
    private LocalDate startDate;
    @Column(name="end_date")
    private LocalDate endDate;
}

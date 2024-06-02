package com.ds.medicalclinic.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.MERGE)
    private User user;

    @OneToOne(cascade = CascadeType.MERGE)
    private Doctor doctor;

    @OneToOne(cascade = CascadeType.MERGE)
    private Service service;

    private String date;



}

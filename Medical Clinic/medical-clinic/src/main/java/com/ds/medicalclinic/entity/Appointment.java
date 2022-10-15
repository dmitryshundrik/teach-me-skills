package com.ds.medicalclinic.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

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

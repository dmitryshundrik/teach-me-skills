package com.ds.medicalclinic.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    private String dateTime;

}

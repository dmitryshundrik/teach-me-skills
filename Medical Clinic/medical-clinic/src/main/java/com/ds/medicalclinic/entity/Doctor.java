package com.ds.medicalclinic.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String specialty;
    private String info;
    private String imageId;

}

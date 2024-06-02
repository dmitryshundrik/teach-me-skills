package com.ds.medicalclinic.model;

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

    @OneToOne(cascade = CascadeType.ALL)
    private Specialty specialty;

    private String info;

    private String imageId;

}

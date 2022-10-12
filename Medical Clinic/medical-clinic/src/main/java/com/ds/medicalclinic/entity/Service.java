package com.ds.medicalclinic.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "services")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    private String name;

    private String price;

    private String info;

}

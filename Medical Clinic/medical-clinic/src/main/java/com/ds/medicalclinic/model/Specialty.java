package com.ds.medicalclinic.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "specialties")
public class Specialty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String url;

    @Column(columnDefinition="TEXT")
    private String info;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Service> services;


}

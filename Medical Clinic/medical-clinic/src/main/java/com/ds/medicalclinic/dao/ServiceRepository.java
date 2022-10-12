package com.ds.medicalclinic.dao;

import com.ds.medicalclinic.entity.Service;
import com.ds.medicalclinic.entity.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Long> {

    public List<Service> findAllBySpecialty(Specialty specialty);

}

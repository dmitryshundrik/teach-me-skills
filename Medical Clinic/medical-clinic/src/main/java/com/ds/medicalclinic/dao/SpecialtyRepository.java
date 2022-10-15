package com.ds.medicalclinic.dao;

import com.ds.medicalclinic.entity.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {

    Specialty findSpecialtyByUrl(String url);

    Specialty findSpecialtyById(Long id);

}

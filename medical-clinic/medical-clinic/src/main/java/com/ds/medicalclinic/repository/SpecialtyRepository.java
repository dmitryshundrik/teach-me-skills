package com.ds.medicalclinic.repository;

import com.ds.medicalclinic.model.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {

    Specialty findSpecialtyByUrl(String url);

    Specialty findSpecialtyById(Long id);

}

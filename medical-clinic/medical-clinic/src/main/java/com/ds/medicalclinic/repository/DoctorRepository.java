package com.ds.medicalclinic.repository;

import com.ds.medicalclinic.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Doctor findDoctorById(Long id);

    List<Doctor> findAllBySpecialty_Id(Long specialtyId);
}

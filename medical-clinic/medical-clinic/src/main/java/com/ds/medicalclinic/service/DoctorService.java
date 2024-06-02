package com.ds.medicalclinic.service;

import com.ds.medicalclinic.repository.DoctorRepository;
import com.ds.medicalclinic.model.Doctor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor findDoctorById(Long id) {
        log.info("Find doctor by doctor_ID: {}", id);
        return doctorRepository.findDoctorById(id);
    }

    public List<Doctor> findAllDoctors() {
        log.info("Find all doctors");
        return doctorRepository.findAll();
    }

    public List<Doctor> findAllDoctorsBySpecialtyId(Long specialtyId) {
        log.info("Find all doctors by specialty_ID: {}", specialtyId);
        return doctorRepository.findAllBySpecialty_Id(specialtyId);
    }
}

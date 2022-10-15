package com.ds.medicalclinic.service;

import com.ds.medicalclinic.dao.DoctorRepository;
import com.ds.medicalclinic.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor findDoctorById(Long id) {
        return doctorRepository.findDoctorById(id);
    }

    public List<Doctor> findAllDoctors() {
        return doctorRepository.findAll();
    }

    public List<Doctor> findAllDoctorsBySpecialtyId(Long specialtyId) {
        return doctorRepository.findAllBySpecialty_Id(specialtyId);
    }
}

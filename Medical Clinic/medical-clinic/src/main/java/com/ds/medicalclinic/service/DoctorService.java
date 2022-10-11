package com.ds.medicalclinic.service;

import com.ds.medicalclinic.dao.DoctorRepository;
import com.ds.medicalclinic.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Optional<Doctor> findById(Long id) {
        return doctorRepository.findById(id);
    }

    public List<Doctor> findAll() {
        List<Doctor> doctors = new ArrayList<>(doctorRepository.findAll());
        return doctors;
    }
}

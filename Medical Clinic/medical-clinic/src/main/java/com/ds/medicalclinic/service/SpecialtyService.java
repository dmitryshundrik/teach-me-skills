package com.ds.medicalclinic.service;

import com.ds.medicalclinic.dao.SpecialtyRepository;
import com.ds.medicalclinic.entity.Specialty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialtyService {
    @Autowired
    private SpecialtyRepository specialtyRepository;

    public Specialty findSpecialtyByUrl(String url) {
        return specialtyRepository.findSpecialtyByUrl(url);
    }

    public Specialty findSpecialtyById(Long id) {
        return specialtyRepository.findSpecialtyById(id);
    }

    public List<Specialty> findAllSpecialties() {
        return specialtyRepository.findAll();
    }

}

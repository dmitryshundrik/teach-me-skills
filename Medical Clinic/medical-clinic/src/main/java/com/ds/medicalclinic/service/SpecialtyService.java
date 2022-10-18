package com.ds.medicalclinic.service;

import com.ds.medicalclinic.repository.SpecialtyRepository;
import com.ds.medicalclinic.model.Specialty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SpecialtyService {
    @Autowired
    private SpecialtyRepository specialtyRepository;

    public Specialty findSpecialtyByUrl(String url) {
        log.info("Find specialty by url: {}", url);
        return specialtyRepository.findSpecialtyByUrl(url);
    }

    public Specialty findSpecialtyById(Long id) {
        log.info("Find specialty by specialty_ID: {}", id);
        return specialtyRepository.findSpecialtyById(id);
    }

    public List<Specialty> findAllSpecialties() {
        log.info("Find all specialties");
        return specialtyRepository.findAll();
    }

}

package com.ds.medicalclinic.service;

import com.ds.medicalclinic.dao.ServiceRepository;
import com.ds.medicalclinic.entity.Specialty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    public List<com.ds.medicalclinic.entity.Service> getServices(Specialty  specialty) {
        return new ArrayList<>(serviceRepository.findAllBySpecialty(specialty));
    }
}

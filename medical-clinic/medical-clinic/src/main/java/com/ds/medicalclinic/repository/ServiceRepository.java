package com.ds.medicalclinic.repository;

import com.ds.medicalclinic.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {

    Service findServiceById(Long id);

}

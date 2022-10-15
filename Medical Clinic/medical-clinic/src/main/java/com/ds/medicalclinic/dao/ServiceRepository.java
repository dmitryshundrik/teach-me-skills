package com.ds.medicalclinic.dao;

import com.ds.medicalclinic.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {

    Service findServiceById(Long id);

}

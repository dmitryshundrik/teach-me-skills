package com.ds.medicalclinic.dao;

import com.ds.medicalclinic.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findAllByUserId(Long id);

    void deleteAppointmentById(Long id);
}

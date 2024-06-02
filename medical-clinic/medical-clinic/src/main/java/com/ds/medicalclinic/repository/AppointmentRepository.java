package com.ds.medicalclinic.repository;

import com.ds.medicalclinic.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findAllByUserId(Long id);

    Appointment findAppointmentById(Long id);

    void deleteAppointmentById(Long id);
}

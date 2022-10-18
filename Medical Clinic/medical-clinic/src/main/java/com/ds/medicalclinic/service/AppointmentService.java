package com.ds.medicalclinic.service;

import com.ds.medicalclinic.repository.AppointmentRepository;
import com.ds.medicalclinic.repository.ServiceRepository;
import com.ds.medicalclinic.dto.ChoiceResultDto;
import com.ds.medicalclinic.model.Appointment;
import com.ds.medicalclinic.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private ServiceRepository serviceRepository;

    public Appointment save(ChoiceResultDto choiceResultDto, User currentUser) {
        log.info("Save appointment for user_ID: {}", currentUser.getId());
        Appointment appointment = new Appointment();
        appointment.setUser(currentUser);
        appointment.setDoctor(doctorService.findDoctorById(choiceResultDto.getDoctorId()));
        appointment.setService(serviceRepository.findServiceById(choiceResultDto.getServiceId()));
        appointment.setDate(choiceResultDto.getDate());
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> findAllByUserId(Long id) {
        log.info("Find all appointments by user_ID: {}", id);
        return appointmentRepository.findAllByUserId(id);
    }

    public Optional<Appointment> findAppointmentById(Long id) {
        log.info("Find appointment by appointment_ID: {}", id);
        return Optional.of(appointmentRepository.findAppointmentById(id));
    }

    @Transactional
    public void deleteAppointmentById(Long id) {
        log.info("Delete appointment by appointment_ID: {}", id);
        appointmentRepository.deleteAppointmentById(id);
    }
}

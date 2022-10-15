package com.ds.medicalclinic.service;

import com.ds.medicalclinic.dao.AppointmentRepository;
import com.ds.medicalclinic.dao.ServiceRepository;
import com.ds.medicalclinic.dto.ChoiceResult;
import com.ds.medicalclinic.entity.Appointment;
import com.ds.medicalclinic.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private ServiceRepository serviceRepository;

    public void save(ChoiceResult choiceResult, User currentUser) {
        Appointment appointment = new Appointment();
        appointment.setUser(currentUser);
        appointment.setDoctor(doctorService.findDoctorById(choiceResult.getDoctorId()));
        appointment.setService(serviceRepository.findServiceById(choiceResult.getServiceId()));
        appointment.setDate(choiceResult.getDate());

        appointmentRepository.save(appointment);
    }

    public List<Appointment> findAllByUserId(Long id) {
        return appointmentRepository.findAllByUserId(id);
    }

    @Transactional
    public void deleteAppointmentById(Long id) {
        appointmentRepository.deleteAppointmentById(id);
    }
}

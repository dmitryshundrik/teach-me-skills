package com.ds.medicalclinic.service;

import com.ds.medicalclinic.dto.ChoiceResultDto;
import com.ds.medicalclinic.model.Appointment;
import com.ds.medicalclinic.model.User;
import com.ds.medicalclinic.repository.AppointmentRepository;
import com.ds.medicalclinic.repository.ServiceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AppointmentServiceTest {

    @MockBean
    private AppointmentService appointmentService;

    @Test
    void save() {
        User currentUser = new User();
        currentUser.setUsername("username");
        currentUser.setPassword("password");
        ChoiceResultDto choiceResultDto = new ChoiceResultDto();
        choiceResultDto.setSpecialtyId(1L);
        choiceResultDto.setDoctorId(1L);
        choiceResultDto.setServiceId(1L);
        appointmentService.save(choiceResultDto, currentUser);

    }

    @Test
    void deleteAppointmentById() {
        appointmentService.deleteAppointmentById(1L);
        Optional<Appointment> optionalAppointment = appointmentService.findAppointmentById(1L);
        assertFalse(optionalAppointment.isPresent());
    }
}
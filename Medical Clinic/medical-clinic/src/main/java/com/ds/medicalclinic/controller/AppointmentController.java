package com.ds.medicalclinic.controller;

import com.ds.medicalclinic.dto.ChoiceResultDto;
import com.ds.medicalclinic.model.User;
import com.ds.medicalclinic.service.AppointmentService;
import com.ds.medicalclinic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Optional;


@Controller
@RequestMapping("")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private UserService userService;

    @GetMapping("/appointment")
    public String appointment(Model model) {
        model.addAttribute("choiceResultDto", new ChoiceResultDto());
        return "account/appointment";
    }

    @PostMapping("/appointment")
    public String appointment(Model model, @ModelAttribute("choiceResultDto") ChoiceResultDto choiceResultDto, HttpSession session) {
        model.addAttribute("choiceResultDto", choiceResultDto);
        if (choiceResultDto.getSpecialtyId() != null && choiceResultDto.getDoctorId() != null
                && choiceResultDto.getServiceId() != null && choiceResultDto.getDate() != null) {
            appointmentService.save(choiceResultDto, userService.findCurrentUser());
            return "redirect:/";
        }
        return "account/appointment";
    }
}

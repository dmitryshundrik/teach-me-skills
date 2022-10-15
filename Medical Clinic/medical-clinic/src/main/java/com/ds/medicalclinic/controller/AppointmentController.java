package com.ds.medicalclinic.controller;

import com.ds.medicalclinic.dto.ChoiceResult;
import com.ds.medicalclinic.entity.User;
import com.ds.medicalclinic.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @GetMapping("/appointment")
    public String appointment(Model model) {
        model.addAttribute("choiceResult", new ChoiceResult());
        return "account/appointment";
    }

    @PostMapping("/appointment")
    public String appointment(Model model, @ModelAttribute("choiceResult") ChoiceResult choiceResult, HttpSession session) {
        model.addAttribute("choiceResult", choiceResult);
        if (choiceResult.getSpecialtyId() != null && choiceResult.getDoctorId() != null
                && choiceResult.getServiceId() != null && choiceResult.getDate() != null) {
            appointmentService.save(choiceResult, (User) session.getAttribute("currentUser"));
            return "redirect:/";
        }
        return "account/appointment";
    }
}

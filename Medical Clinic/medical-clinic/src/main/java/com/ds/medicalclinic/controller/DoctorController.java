package com.ds.medicalclinic.controller;

import com.ds.medicalclinic.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/staff")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/doctor/{id}")
    public String findById(@PathVariable String id, Model model) {
        model.addAttribute("doctor", doctorService.findById(Long.valueOf(id)).get());
        return "doctor";
    }

    @GetMapping("/all")
    public String findAll(Model model) {
        model.addAttribute("staff", doctorService.findAll());
        return "staff";
    }
}

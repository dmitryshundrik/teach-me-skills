package com.ds.medicalclinic.controller;

import com.ds.medicalclinic.entity.Specialty;
import com.ds.medicalclinic.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @GetMapping("/services/{specialty}")
    public String services(@PathVariable Specialty specialty, Model model) {
        model.addAttribute("specialty", serviceService.getServices(specialty));
        return "services";
    }
}

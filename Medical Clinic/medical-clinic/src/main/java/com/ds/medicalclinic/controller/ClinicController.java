package com.ds.medicalclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class ClinicController {

    @GetMapping("/sales")
    public String sales() {
        return "sales";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }
}

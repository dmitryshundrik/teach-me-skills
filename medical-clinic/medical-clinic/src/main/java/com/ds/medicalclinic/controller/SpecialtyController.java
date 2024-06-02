package com.ds.medicalclinic.controller;

import com.ds.medicalclinic.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class SpecialtyController {

    @Autowired
    private SpecialtyService specialtyService;

    @GetMapping("/specialty/{url}")
    public String specialty(@PathVariable String url, Model model) {
        model.addAttribute("specialty", specialtyService.findSpecialtyByUrl(url));
        return "clinic/specialty";
    }
}

package by.tms.lesson41homework.controller;

import by.tms.lesson41homework.entity.Operation;
import by.tms.lesson41homework.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/calc")
    public String calculator(){
        return "calc";
    }

    @PostMapping("/calc")
    public String calculator(Operation operation, Model model) {
        String result = calculatorService.executeOperation(operation);
        model.addAttribute("message", result);
        return "calc";
    }
 }

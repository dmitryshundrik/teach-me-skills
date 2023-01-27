package by.tms.lesson41homework.controller;

import by.tms.lesson41homework.entity.Operation;
import by.tms.lesson41homework.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/calc")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping
    public String main(Model model) {
        model.addAttribute("operation", new Operation());
        return "calc";
    }

    @PostMapping
    public String main(@Valid @ModelAttribute("operation") Operation operation, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "calc";
        }
        calculatorService.save(operation);
        String result = calculatorService.executeOperation(operation);
        model.addAttribute("result", result);
        return "calc";
    }

    @GetMapping("/history")
    public String history(Model model) {
        model.addAttribute("operations", calculatorService.findAllOperations());
        return "history";
    }
}

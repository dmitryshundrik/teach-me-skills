package by.tms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import by.tms.entity.Calculator;
import by.tms.service.CalculatorService;

@Controller
@RequestMapping("/calc")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/main")
    public ModelAndView calculator(ModelAndView modelAndView) {
        modelAndView.setViewName("calculator");
        return modelAndView;
    }

    @PostMapping("/main")
    public ModelAndView calculator(Calculator calculator, ModelAndView modelAndView) {
        modelAndView.addObject("result", String.valueOf(calculatorService.execute(calculator)));
        modelAndView.setViewName("calculator");
        return modelAndView;
    }

}

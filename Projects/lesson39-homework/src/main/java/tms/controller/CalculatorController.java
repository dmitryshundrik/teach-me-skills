package tms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import tms.entity.Calculator;
import tms.service.CalculatorService;

@Controller
@RequestMapping("/app/calc")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/home")
    public ModelAndView calculator(ModelAndView modelAndView) {
        modelAndView.setViewName("calculator");
        return modelAndView;
    }

    @PostMapping("/home")
    public ModelAndView calculator(Calculator calculator, ModelAndView modelAndView) {
        if (calculator.getSecondNumber().equals("0") && calculator.getOperation().equals("/")) {
            throw new RuntimeException("error");
        }
        modelAndView.addObject("result", String.valueOf(calculatorService.execute(calculator)));
        modelAndView.setViewName("calculator");
        return modelAndView;
    }

}

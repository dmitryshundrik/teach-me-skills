package by.tms.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExControllerAdvice {

    @ExceptionHandler({RuntimeException.class})
    public String handlerException(RuntimeException e, Model model) {
        model.addAttribute("message", e.getMessage());
        return "error";
    }

}

package com.ds.medicalclinic.controller;

import com.ds.medicalclinic.dto.UserDto;
import com.ds.medicalclinic.exception.UserAlreadyExistException;
import com.ds.medicalclinic.model.User;
import com.ds.medicalclinic.service.AppointmentService;
import com.ds.medicalclinic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/login")
    public String login() {
        return "account/login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("message", "Неверный логин и/или пароль");
        return "account/login";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "account/signup";
    }

    @PostMapping("/signup")
    public String signup(@Valid @ModelAttribute("userDto") UserDto userDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("message", "Заполните все поля");
            return "account/signup";
        }
        try {
            userService.save(userDto);
        } catch (UserAlreadyExistException uaeEx) {
            model.addAttribute("message", "An account for that username already exists.");
            return "account/signup";
        }
        return "redirect:/";
    }

    @GetMapping("/account")
    public String account(Model model) {
        User currentUser = userService.findCurrentUser();
        model.addAttribute("appointments", appointmentService.findAllByUserId(currentUser.getId()));
        model.addAttribute("user", currentUser);
        return "account/account";
    }

    @GetMapping("/delete/appointment/{id}")
    public String deleteAppointment(Model model, HttpSession session, @PathVariable String id) {
        appointmentService.deleteAppointmentById(Long.valueOf(id));
        User currentUser = userService.findCurrentUser();
        model.addAttribute("appointments", appointmentService.findAllByUserId(currentUser.getId()));
        model.addAttribute("user", currentUser);
        return "account/account";
    }

    @GetMapping("/delete/account")
    public String deleteAccount(HttpSession session) {
        User currentUser = userService.findCurrentUser();
        userService.deleteUserById(currentUser.getId());
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout() {
        SecurityContextHolder.clearContext();
        return "redirect:/";
    }
}

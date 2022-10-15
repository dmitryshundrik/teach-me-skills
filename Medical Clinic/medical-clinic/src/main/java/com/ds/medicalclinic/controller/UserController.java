package com.ds.medicalclinic.controller;

import com.ds.medicalclinic.entity.User;
import com.ds.medicalclinic.dto.LoginUserDto;
import com.ds.medicalclinic.service.AppointmentService;
import com.ds.medicalclinic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("newUser", new User());
        return "account/signup";
    }

    @PostMapping("/signup")
    public String signup(@Valid @ModelAttribute("newUser") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "account/signup";
        }
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("userModel", new LoginUserDto());
        return "account/login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("userModel") LoginUserDto user, BindingResult bindingResult,
                        Model model, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "account/login";
        }
        Optional<User> byUsername = userService.findUserByUsername(user.getUsername());
        if (byUsername.isPresent()) {
            User userByUsername = byUsername.get();
            if (userByUsername.getPassword().equals(user.getPassword())) {
                session.setAttribute("currentUser", userByUsername);
                return "redirect:/";
            } else {
                model.addAttribute("message", "Wrong password!");
            }
        } else {
            model.addAttribute("message", "User not found!");
        }
        return "account/login";
    }

    @GetMapping("/account")
    public String account(Model model, HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        model.addAttribute("appointments", appointmentService.findAllByUserId(currentUser.getId()));
        model.addAttribute("user", currentUser);
        return "account/account";
    }

    @GetMapping("/delete/appointment/{id}")
    public String deleteAppointment(Model model, HttpSession session, @PathVariable String id) {
        appointmentService.deleteAppointmentById(Long.valueOf(id));
        User currentUser = (User) session.getAttribute("currentUser");
        model.addAttribute("appointments", appointmentService.findAllByUserId(currentUser.getId()));
        model.addAttribute("user", currentUser);
        return "account/account";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}

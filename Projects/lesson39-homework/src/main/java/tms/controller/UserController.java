package tms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tms.entity.User;
import tms.service.UserService;
import javax.validation.Valid;

@Controller
@RequestMapping("app/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/reg")
    public String registration(Model model) {
        model.addAttribute("newUser", new User());
        return "registration";
    }

    @PostMapping("/reg")
    public String registration(@Valid @ModelAttribute("newUser") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
        } else {
            userService.save(user);
            return "redirect:/app/calc/home";
        }
    }
}

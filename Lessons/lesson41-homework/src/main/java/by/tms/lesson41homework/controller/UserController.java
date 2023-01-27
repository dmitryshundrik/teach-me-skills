package by.tms.lesson41homework.controller;

import by.tms.lesson41homework.entity.User;
import by.tms.lesson41homework.model.AccountUserModel;
import by.tms.lesson41homework.model.LoginUserModel;
import by.tms.lesson41homework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/reg")
    public String registration(Model model) {
        model.addAttribute("newUser", new User());
        return "reg";
    }

    @PostMapping("/reg")
    public String registration(@Valid @ModelAttribute("newUser") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "reg";
        }
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("userModel", new LoginUserModel());
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("userModel") LoginUserModel user, BindingResult bindingResult,
                        Model model, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        Optional<User> byUsername = userService.findByUsername(user.getUsername());
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
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/account")
    public String account(Model model) {
        model.addAttribute("accountUserModel", new AccountUserModel());
        return "account";
    }

    @PostMapping("/account")
    public String account(@ModelAttribute("accountUserModel") AccountUserModel accountUserModel, Model model, HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        if (!accountUserModel.getNewName().isBlank()) {
            currentUser.setName(accountUserModel.getNewName());
        }
        if (!accountUserModel.getNewPassword().isBlank()) {
            if (currentUser.getPassword().equals(accountUserModel.getCurrentPassword())) {
                currentUser.setPassword(accountUserModel.getNewPassword());
            } else {
                model.addAttribute("message", "Wrong current password!");
                return "account";
            }
        }
        session.setAttribute("currentUser", currentUser);
        return "redirect:/";
    }
}

package by.tms.controller;

import by.tms.entity.Telephone;
import by.tms.entity.User;
import by.tms.model.LoginUserModel;
import by.tms.model.RegistrationUserModel;
import by.tms.model.SettingsUserModel;
import by.tms.service.UserService;
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
        model.addAttribute("registrationUserModel", new RegistrationUserModel());
        return "registration";
    }

    @PostMapping("/reg")
    public String registration(@Valid @ModelAttribute("registrationUserModel") RegistrationUserModel registrationUserModel,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        User user = userService.userModelToUserConverter(registrationUserModel);
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginUserModel", new LoginUserModel());
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("loginUserModel") LoginUserModel loginUserModel, BindingResult bindingResult,
                        Model model, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        Optional<User> optionalUser = userService.findByUsername(loginUserModel.getUsername());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getPassword().equals(loginUserModel.getPassword())) {
                session.setAttribute("currentUser", user);
                return "redirect:/";
            } else {
                model.addAttribute("message", "Wrong password!");
            }
        } else {
            model.addAttribute("message", "User not found!");
        }
        return "login";
    }

    @GetMapping("/settings")
    public String settings(Model model) {
        model.addAttribute("settingsUserModel", new SettingsUserModel());
        return "settings";
    }

    @PostMapping("/settings")
    public String settings(@ModelAttribute("settingsUserModel") SettingsUserModel settingsUserModel, Model model,
                           HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        if (!settingsUserModel.getNewName().isBlank()) {
            currentUser.setName(settingsUserModel.getNewName());
            model.addAttribute("message", "Name changed!");
        }

        if (!settingsUserModel.getNewPhoneNumber1().isBlank()) {
            currentUser.getTelephones().set(0, new Telephone(0, settingsUserModel.getNewPhoneNumber1()));
            model.addAttribute("message", "Phone number changed!");
        }

        if (!settingsUserModel.getNewPhoneNumber2().isBlank()) {
            currentUser.getTelephones().set(1, new Telephone(0, settingsUserModel.getNewPhoneNumber2()));
            model.addAttribute("message", "Phone number changed!");
        }

        if (!settingsUserModel.getNewPassword().isBlank()) {
            if (currentUser.getPassword().equals(settingsUserModel.getCurrentPassword())) {
                currentUser.setPassword(settingsUserModel.getNewPassword());
                model.addAttribute("message", "Password changed!");
            } else {
                model.addAttribute("message", "Wrong current password!");
            }
        }
        userService.update(currentUser);
        session.setAttribute("currentUser", currentUser);
        return "settings";
    }

    @GetMapping("/delete")
    public String delete(HttpSession session) {
        userService.delete(((User) session.getAttribute("currentUser")).getId());
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}

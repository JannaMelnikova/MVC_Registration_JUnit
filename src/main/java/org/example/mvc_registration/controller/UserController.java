package org.example.mvc_registration.controller;


import org.example.mvc_registration.model.User;
import org.example.mvc_registration.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    //

   private UserService userService;

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";//назваие html-страницы из папки templates
    }

    @PostMapping("/register")//получаем объект из html-страницы
    public String processRegistration(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {//при вводе логина страница возвращает login
        return "login";
    }
}

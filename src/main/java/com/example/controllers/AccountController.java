package com.example.controllers;

import com.example.models.AppRole;
import com.example.models.AppUser;
import com.example.services.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;

@Controller
@RequiredArgsConstructor
public class AccountController {

    private final AppUserService userService;

    @GetMapping("/login")
    public String getLogin(Model model) {

        return "user/login";
    }

    @PostMapping("/login")
    public String postLogin(Model model) {

        model.addAttribute("user", new AppUser());
        return "home/index";
    }

    @GetMapping("/registration")
    public String registration(Model model) {

        return "user/registration";
    }

    @PostMapping("/registration")
    public String postRegistration(Model model, AppUser user) {

        return userService.saveUser(user) ? "redirect:/login" : "user/registration";
//        return userService.saveUser(user) ?
//                new ModelAndView("redirect:/login", "model",
//                        model.addAttribute("mes", null))
//                : new ModelAndView("user/registration", "model",
//                        model.addAttribute("mes", "Пользователь существует либо пароли не совпадают"));
    }

    @GetMapping("/logout")
    public String logout(Model model) {

        return "user/logout";
    }
}
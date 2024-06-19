package com.alke.wallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.alke.wallet.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;
    
    @GetMapping
    public String showLoginForm(Model model) {
        return "login";
    }
    
    @PostMapping
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        if (loginService.login(username, password)) {
            return "redirect:/";
        } else {
            return "login";
        }
    }
}
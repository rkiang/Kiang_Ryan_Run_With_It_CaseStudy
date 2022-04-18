package com.optum.runwithitapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @PostMapping("/login")
    public String login(Model model) {
        return "welcome";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }
}
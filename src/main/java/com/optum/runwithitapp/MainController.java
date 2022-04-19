package com.optum.runwithitapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @GetMapping("/")
    public String root() {
        return "login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

//    @GetMapping("/logout")
//    public String logout(HttpServletRequest request){
//        HttpSession httpSession = request.getSession();
//        httpSession.invalidate();
//        return "redirect:/";
//    }

//    @GetMapping("/user")
//    public String userIndex() {
//        return "user/index";
//    }
}
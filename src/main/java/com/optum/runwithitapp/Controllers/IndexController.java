package com.optum.runwithitapp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {


//    @RequestMapping("/create")
//    public String indexCreateAccount(){
//        return "create_account";
//    }
//    @GetMapping("/")
//    public String root() {
//        return "index";
//    }

    @GetMapping("/login")
    public String login(Model model) {
        return "index";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }

//    @RequestMapping("/login")
//    public String indexLogin(){
//        return "login";
//    }

//    @RequestMapping("/admin")
//    public String adminSettings(){
//        return "admin";
//    }

//    @RequestMapping(value="/exercise", method= RequestMethod.GET)
//    public String exercisePage(){
//        return "/exercise";
//    }
}

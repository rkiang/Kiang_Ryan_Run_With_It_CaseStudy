package com.optum.runwithitapp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {


    @RequestMapping("/registration")
    public String indexCreateAccount(){
        return "registration";
    }

    @GetMapping("/welcome")
    public String welcomePage(){
        return "welcome";
    }


}

package com.optum.runwithitapp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {


    @RequestMapping("/create")
    public String indexCreateAccount(){
        return "create_account";
    }

    @RequestMapping("/login")
    public String indexLogin(){
        return "login";
    }
}

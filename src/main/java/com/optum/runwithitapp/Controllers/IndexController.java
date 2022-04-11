package com.optum.runwithitapp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {


    @RequestMapping("/create")
    public String indexCreateAccount(){
        return "create_account";
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

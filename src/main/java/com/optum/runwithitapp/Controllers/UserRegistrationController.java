package com.optum.runwithitapp.Controllers;


import com.optum.runwithitapp.Models.Users;
import com.optum.runwithitapp.Registration.UserRegistrationDto;
import com.optum.runwithitapp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @ModelAttribute("users")
    public UserRegistrationDto userRegistrationDto(){
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model){
        return "create_account";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("users") @Valid UserRegistrationDto userRegistrationDto,
                                      BindingResult bindingResult){
        Users existing = userService.findByUsername((userRegistrationDto.getUsername()));
        if(existing != null){
            bindingResult.rejectValue("username", null, "Username already exists, try another username");
        }
        if (bindingResult.hasErrors()){
            return "create_account";
        }
        userService.save(userRegistrationDto);
//        return "redirect:/create_account?success";
        return "redirect:/";
    }
}

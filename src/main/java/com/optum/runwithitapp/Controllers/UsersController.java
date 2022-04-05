package com.optum.runwithitapp.Controllers;

import com.optum.runwithitapp.Models.Users;
import com.optum.runwithitapp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsersController {
    private UserService userService;

    public UsersController() {
    }

    @Autowired
    public UsersController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String getAllUsers(Model model){
        model.addAttribute("listUsers", userService.getAllUsers());
        return "admin";
    }

    @GetMapping("/create")
    public String displayCreateAccountForm(Model model){
        Users users = new Users();
        model.addAttribute("users", users);
        return "create_account";
    }

    @PostMapping("/createNewAccount")
    public String saveNewUser(@ModelAttribute("users") Users users){
        userService.saveUsers(users);
        return "redirect:/";
    }

    @GetMapping("/accounts/{id}")
    public String displayFormUpdates(@PathVariable(value = "id") long id, Model model){
        Users users = userService.getUsersById(id);
        model.addAttribute("users", users);
        return "update_users";
    }
    @GetMapping("/deleteUser/{id}")
//    @DeleteMapping("/deleteUser/{id}")
    public String deleteUsers(@PathVariable(value = "id") long id){
        this.userService.deleteUsersById(id);
        return "admin";
    }
}

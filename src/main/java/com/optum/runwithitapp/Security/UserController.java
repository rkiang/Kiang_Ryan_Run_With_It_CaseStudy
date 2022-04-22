package com.optum.runwithitapp.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private UserService userService;

    public UserController() {
    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String getAllUsers(Model model) {
        model.addAttribute("listUsers", userService.getAllUsers());
        return "admin";
    }

    @GetMapping("/user")
    public String getUserProfile(Principal principal, Model model){
        User user = userService.findByEmail(principal.getName());
        model.addAttribute("listUserProfile", userService.getUserById(user.getId()));
        return "user";
    }

    @GetMapping("/profileUpdate/{id}")
    public String displayFormUpdates(@PathVariable(value = "id") long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "redirect:/profile";
    }

    @PostMapping("/updateUser")
    public String saveUpdateUser(@ModelAttribute User user){
        userService.saveUserInfo(user);
        return "redirect:/profile";
    }
    @GetMapping("/deleteUser/{id}")
//    @DeleteMapping("/deleteUser/{id}")
    public String deleteUsers(@PathVariable(value = "id") long id) {
        this.userService.deleteUsersById(id);
        return "redirect:/admin";
    }


}

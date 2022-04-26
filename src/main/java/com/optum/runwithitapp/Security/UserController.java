package com.optum.runwithitapp.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.HashSet;

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

    /*admin allows admin users to view all users*/
    @GetMapping("/admin")
    public String getAllUsers(Model model) {
        model.addAttribute("listUsers", userService.getAllUsers());
        return "admin";
    }

    /*Gets user by email during session and returns their info*/
    @GetMapping("/user")
    public String getUserProfile(Principal principal, Model model){
        User user = userService.findByEmail(principal.getName());
        model.addAttribute("listUserProfile", userService.getUserById(user.getId()));
        return "user";
    }

    /*Ability for each user to view their own user data when logged in*/
    @GetMapping("/profileUpdate/{email}")
    public String displayFormUpdates(@PathVariable(value = "email") long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "redirect:/user";
    }

    /*Updates user info (not password) on user page, edit form*/
    @PostMapping("/updateUser/{id}")
    public String saveUpdateUser(@PathVariable("id") long id,
                                 @ModelAttribute User user, Model model){
        userService.saveUserInfo(user);
        return "redirect:/user";
    }


    /*Admin only function to delete user accounts on admin page*/
    @GetMapping("/deleteUser/{id}")
    public String deleteUsers(@PathVariable(value = "id") long id) {
        this.userService.deleteUsersById(id);
        return "redirect:/admin";
    }


}

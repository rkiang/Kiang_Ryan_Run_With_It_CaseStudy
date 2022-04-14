package com.optum.runwithitapp.Controllers;

import com.optum.runwithitapp.Models.Users;
import com.optum.runwithitapp.Repositories.UserRepository;
import com.optum.runwithitapp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class UsersController {

    private UserRepository userRepository;

    public UsersController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/welcome")
    public String testing(Principal principal, Model model){
        Users users = userRepository.findByUsername(principal.getName());
        model.addAttribute("username", principal.getName());
        model.addAttribute("user", users.getUsername());
        return "welcome";
    }

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

    @GetMapping("/index")
    public String login(){
        return "exercise";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "redirect:/";
    }
}

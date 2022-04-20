//package com.optum.runwithitapp.Security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import java.security.Principal;
//
//@Controller
//public class UserController {
//
//    private UserRepository userRepository;
//
//    public UserController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @GetMapping("/welcome")
//    public String testing(Principal principal, Model model) {
//        User user = userRepository.findByUsername(principal.getName());
//        model.addAttribute("username", principal.getName());
//        model.addAttribute("user", user.getUsername());
//        return "welcome";
//    }
//
//    private UserService userService;
//
//    public UserController() {
//    }
//
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping("/admin")
//    public String getAllUsers(Model model) {
//        model.addAttribute("listUsers", userService.getAllUsers());
//        return "admin";
//    }
//
//    @GetMapping("/create")
//    public String displayCreateAccountForm(Model model) {
//        User user = new User();
//        model.addAttribute("user", user);
//        return "create_account";
//    }
//
//    @PostMapping("/createNewAccount")
//    public String saveNewUser(@ModelAttribute("users") User users) {
//        userService.saveUsers(users);
//        return "redirect:/";
//    }
//
//    @GetMapping("/accounts/{id}")
//    public String displayFormUpdates(@PathVariable(value = "id") long id, Model model) {
//        User user = userService.getUsersById(id);
//        model.addAttribute("user", user);
//        return "update_users";
//    }
//
//    @GetMapping("/deleteUser/{id}")
////    @DeleteMapping("/deleteUser/{id}")
//    public String deleteUsers(@PathVariable(value = "id") long id) {
//        this.userService.deleteUsersById(id);
//        return "redirect:/admin";
//    }
//
//
//}
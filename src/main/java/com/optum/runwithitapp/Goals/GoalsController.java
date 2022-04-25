package com.optum.runwithitapp.Goals;

import com.optum.runwithitapp.Security.User;
import com.optum.runwithitapp.Security.UserRepository;
import com.optum.runwithitapp.Security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.Set;

@Controller
public class GoalsController {
    public GoalsService goalsService;
    private UserService userService;
    @Autowired
    public GoalsController(GoalsService goalsService, UserService userService) {
        this.goalsService = goalsService;
        this.userService = userService;
    }


    @GetMapping("/goals")
    public String getAllUserGoals(Principal principal, Model model){
        User user = userService.findByEmail(principal.getName());
        model.addAttribute("username", principal.getName());
        Goals goals = new Goals();
        model.addAttribute("goals", goals);
        model.addAttribute("listGoals", user.getGoals());

        return "goals";
    }

    @PostMapping("/createGoals/{email}")
    public String saveNewGoals(@PathVariable("email") String email,
                                   @ModelAttribute("goals") Goals goals){
        goalsService.saveUserGoals(goals);
        User user = userService.findByEmail(email);
        user.getGoals().add(goals);
        userService.saveUserInfo(user);
        return "redirect:/goals";
    }

    @PostMapping("/updateGoals/{id}")
    public String updateGoals(@PathVariable("id") long id, Goals goals,
                              Model model){
        goalsService.saveUserGoals(goals);
        return "redirect:/goals";
    }

    @GetMapping("/deleteGoals/{id}")
    public String deleteGoals(@PathVariable(value = "id") long id,
                              Principal principal){
        User user = userService.findByEmail(principal.getName());
        Set<Goals> goals = user.getGoals();
        Goals goalsById = goalsService.getUserGoalsById(id);
        goals.remove(goalsById);
        userService.saveUserInfo(user);
        this.goalsService.deleteUserGoalsById(id);
        return "redirect:/goals";
    }


}

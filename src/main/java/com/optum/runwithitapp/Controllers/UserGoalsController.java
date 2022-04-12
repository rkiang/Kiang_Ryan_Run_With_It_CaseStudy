package com.optum.runwithitapp.Controllers;

import com.optum.runwithitapp.Models.UserGoals;
import com.optum.runwithitapp.Services.UserGoalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserGoalsController {
    public UserGoalsService userGoalsService;

    @Autowired
    public UserGoalsController(UserGoalsService userGoalsService) {
        this.userGoalsService = userGoalsService;
    }

    @GetMapping("/goals")
    public String getAllUserGoals(Model model){
        model.addAttribute("listUserGoals", userGoalsService.getAllUserGoals());
        return "goals";
    }

    @GetMapping("/showGoals")
    public String showUserGoalsForm(Model model){
        UserGoals userGoals = new UserGoals();
        model.addAttribute("userGoals", userGoals);
        return "goals";
    }

    @PostMapping("/createGoals")
    public String saveNewGoals(@ModelAttribute("userGoals") UserGoals userGoals){
        userGoalsService.saveUserGoals(userGoals);
        return "redirect:/goals";
    }

    @PostMapping("/updateGoals/{id}")
    public String updateGoals(@PathVariable("id") long id, UserGoals userGoals,
                              Model model){
        userGoalsService.saveUserGoals(userGoals);
        return "redirect:/goals";
    }

    @GetMapping("/deleteGoals/{id}")
    public String deleteGoals(@PathVariable(value = "id") long id){
        this.userGoalsService.deleteUserGoalsById(id);
        return "redirect:/goals";
    }


}

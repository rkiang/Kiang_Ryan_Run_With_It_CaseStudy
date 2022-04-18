package com.optum.runwithitapp.Goals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GoalsController {
    public GoalsService goalsService;

    @Autowired
    public GoalsController(GoalsService goalsService) {
        this.goalsService = goalsService;
    }

    @GetMapping("/goals")
    public String getAllUserGoals(Model model){
        model.addAttribute("listUserGoals", goalsService.getAllUserGoals());
        return "goals";
    }

    @GetMapping("/showGoals")
    public String showUserGoalsForm(Model model){
        Goals goals = new Goals();
        model.addAttribute("userGoals", goals);
        return "goals";
    }

    @PostMapping("/createGoals")
    public String saveNewGoals(@ModelAttribute("userGoals") Goals goals){
        goalsService.saveUserGoals(goals);
        return "redirect:/goals";
    }

    @PostMapping("/updateGoals/{id}")
    public String updateGoals(@PathVariable("id") long id, Goals goals,
                              Model model){
        goalsService.saveUserGoals(goals);
        return "redirect:/goals";
    }

    @GetMapping("/deleteGoals/{id}")
    public String deleteGoals(@PathVariable(value = "id") long id){
        this.goalsService.deleteUserGoalsById(id);
        return "redirect:/goals";
    }


}

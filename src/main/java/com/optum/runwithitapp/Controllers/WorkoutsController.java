package com.optum.runwithitapp.Controllers;

import com.optum.runwithitapp.Models.Workouts;
import com.optum.runwithitapp.Services.WorkoutsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WorkoutsController {
    private WorkoutsService workoutsService;

    public WorkoutsController() {
    }

    @Autowired
    public WorkoutsController(WorkoutsService workoutsService) {
        this.workoutsService = workoutsService;
    }

    @GetMapping("/workouts")
    public String getAllWorkouts(Model model){
        model.addAttribute("listWorkouts", workoutsService.getAllWorkouts());
        return "workouts";
    }

    @GetMapping("/showWorkouts")
    public String showWorkoutForm(Model model){
        return "workouts";
    }

    @PostMapping("/createWorkouts")
    public String saveNewWorkouts(@ModelAttribute("workouts") Workouts workouts){
        workoutsService.saveWorkouts(workouts);
        return "redirect:/workouts";
    }

    @PostMapping("/updateWorkouts/{id}")
    public String updateWorkouts(@PathVariable("id") long id, Workouts workouts,
                                 Model model){
        workoutsService.saveWorkouts(workouts);
        return "redirect:/workouts";
    }

    @GetMapping("/deleteWorkouts/{id}")
    public String deleteWorkouts(@PathVariable(value = "id") long id){
        this.workoutsService.deleteWorkoutsById(id);
        return "redirect:/workouts";
    }
}

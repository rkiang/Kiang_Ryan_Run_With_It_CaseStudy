package com.optum.runwithitapp.Controllers;

import com.optum.runwithitapp.Models.Exercise;
import com.optum.runwithitapp.Services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ExerciseController {
    private ExerciseService exerciseService;

    public ExerciseController() {
    }

    @Autowired
    public ExerciseController(ExerciseService exerciseService){
        this.exerciseService=exerciseService;
    }

    @GetMapping("/exercise")
    public String getAllExercises(Model model){
        model.addAttribute("listExercises", exerciseService.getAllExercises());
        return "exercise";
    }

    @GetMapping("/createExercise")
    public String createExerciseForm(Model model){
        Exercise exercise = new Exercise();
        model.addAttribute("exercise", exercise);
        return "exercise";
    }

    @PostMapping("/createNewExercise")
    public String saveExercise(@ModelAttribute("exercise") Exercise exercise){
        exerciseService.saveExercises(exercise);
        return "exercise";
    }

    @GetMapping("/exercise/{id}")
    public String updateExercises(@PathVariable(value = "exerciseId") long id, Model model){
        Exercise exercise = exerciseService.getExercisesById(id);
        model.addAttribute("exercises", exercise);
        return "exercise";
    }

    @DeleteMapping("/deleteExercise/{id}")
    public String deleteExercise(@PathVariable long id){
        Exercise exercise = exerciseService.getExercisesById(id);
        exerciseService.deleteExercisesById(id);
        return "exercise";
    }

}

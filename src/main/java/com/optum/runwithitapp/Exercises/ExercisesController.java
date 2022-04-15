package com.optum.runwithitapp.Exercises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ExercisesController {

    private ExerciseService exerciseService;

    public ExercisesController() {

    }

    @Autowired
    public ExercisesController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping("/exercise")
    public String getAllExercises(Model model) {
        model.addAttribute("listExercises", exerciseService.getAllExercises());
        return "exercise";
    }

    @GetMapping("/showExercises")
    public String showExercisesForm(Model model) {
        Exercises exercises = new Exercises();
        model.addAttribute("exercises", exercises);
        return "exercise";
    }

    @PostMapping("/createExercises")
    public String saveNewExercises(@ModelAttribute("exercises") Exercises exercises) {
        exerciseService.saveExercises(exercises);
        return "redirect:/exercise";
    }

    @PostMapping("/updatedExercises/{id}")
    public String updateExercises(@PathVariable("id") long id, Exercises exercises,
                                  Model model){
        exerciseService.saveExercises(exercises);
        return "redirect:/exercise";
    }

    @GetMapping("/deleteExercises/{id}")
    public String deleteExercises(@PathVariable(value = "id") long exerciseId) {
        this.exerciseService.deleteExercisesById(exerciseId);
        return "redirect:/exercise";
    }

}

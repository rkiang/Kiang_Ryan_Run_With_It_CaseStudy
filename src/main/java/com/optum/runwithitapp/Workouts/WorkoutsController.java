package com.optum.runwithitapp.Workouts;

import com.optum.runwithitapp.Security.User;
import com.optum.runwithitapp.Security.UserService;
import org.hibernate.jdbc.Work;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class WorkoutsController {
    private WorkoutsService workoutsService;
    private UserService userService;
    private WorkoutsRepository workoutsRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    public WorkoutsController() {
    }

    @Autowired
    public WorkoutsController(WorkoutsService workoutsService, UserService userService, WorkoutsRepository workoutsRepository) {
        this.workoutsService = workoutsService;
        this.userService = userService;
        this.workoutsRepository = workoutsRepository;
    }

    /*Gets all workout information after finding user by email*/
    @GetMapping("/workouts")
    public String getAllWorkouts(Principal principal, Model model) {
        User user = userService.findByEmail(principal.getName());
        model.addAttribute("username", principal.getName());
        Workouts workouts = new Workouts();
        model.addAttribute("workouts", workouts);
        model.addAttribute("listWorkouts", user.getWorkouts());

        LOGGER.info("!!!DATA FROM WORKOUTS LIST!!!");

        return "workouts";
    }

    /*Users can create workout entries*/
    @PostMapping("/createWorkouts/{email}")
    public String saveNewWorkouts(@PathVariable("email") String email,
                                  @ModelAttribute("workouts") Workouts workouts) {
        workoutsService.saveWorkouts(workouts);
        User user = userService.findByEmail(email);
        user.getWorkouts().add(workouts);
        userService.saveUserInfo(user);
        return "redirect:/workouts";
    }

    /*Users can update their workout entries*/
    @PostMapping("/updateWorkouts/{id}")
    public String updateWorkouts(@PathVariable("id") long id, Workouts workouts,
                                 Model model) {
        workoutsService.saveWorkouts(workouts);
        return "redirect:/workouts";
    }

    /*Users can delete their exercises*/
    @GetMapping("/deleteWorkouts/{id}")
    public String deleteWorkouts(@PathVariable(value = "id") long id, Principal principal) {
        User user = userService.findByEmail(principal.getName());
        Set<Workouts> workouts = user.getWorkouts();
        Workouts workout = workoutsService.getWorkoutsById(id);
        workouts.remove(workout);
        userService.saveUserInfo(user);
        this.workoutsService.deleteWorkoutsById(id);
        return "redirect:/workouts";
    }

    /*Query for finding exercises entry by name*/
    @PostMapping("/searchWorkouts")
    public String searchWorkouts(@ModelAttribute Workouts workouts, Model model){
        Set<Workouts> workoutsSet = new HashSet<>();

        if(!workouts.getQueryName().isEmpty()){
            String name = workouts.getQueryName();
            workoutsSet.addAll(workoutsService.getWorkoutsByExerciseName(name));
        }
        model.addAttribute("listWorkouts", workoutsSet);
        return "workouts";
    }

}

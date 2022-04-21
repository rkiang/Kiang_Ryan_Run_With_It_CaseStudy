package com.optum.runwithitapp.Workouts;

import com.optum.runwithitapp.Security.User;
import com.optum.runwithitapp.Security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;
import java.util.Set;

@Controller
public class WorkoutsController {
    private WorkoutsService workoutsService;
    private UserService userService;
    private WorkoutsRepository workoutsRepository;

    public WorkoutsController() {
    }

    @Autowired
    public WorkoutsController(WorkoutsService workoutsService, UserService userService, WorkoutsRepository workoutsRepository) {
        this.workoutsService = workoutsService;
        this.userService = userService;
        this.workoutsRepository = workoutsRepository;
    }

    @GetMapping("/workouts")
    public String getAllWorkouts(Principal principal, Model model) {
        User user = userService.findByEmail(principal.getName());
        model.addAttribute("username", principal.getName());
        Workouts workouts = new Workouts();
        model.addAttribute("workouts", workouts);
        model.addAttribute("listWorkouts", user.getWorkouts());
        return "workouts";
    }

//    @GetMapping("/showWorkouts")
//    public String showWorkoutForm(Model model){
//        return "workouts";
//    }

    @PostMapping("/createWorkouts/{email}")
    public String saveNewWorkouts(@PathVariable("email") String email,
                                  @ModelAttribute("workouts") Workouts workouts) {
        workoutsService.saveWorkouts(workouts);
        User user = userService.findByEmail(email);
        user.getWorkouts().add(workouts);
        userService.saveUserInfo(user);
        return "redirect:/workouts";
    }

    @PostMapping("/updateWorkouts/{id}")
    public String updateWorkouts(@PathVariable("id") long id, Workouts workouts,
                                 Model model) {
        workoutsService.saveWorkouts(workouts);
        return "redirect:/workouts";
    }

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

//    @GetMapping("/workouts/{exerciseName}")
//    public List<Workouts> getWorkoutsByExerciseName(
//            @PathVariable String exerciseName){
//        return workoutsService.getWorkoutsByExerciseName(exerciseName);
//    }

    @GetMapping("/workouts/{exerciseName}")
    public ResponseEntity getWorkoutsByExerciseName(
        @PathVariable("exerciseName") String exerciseName){
    List<Workouts> workouts;
    if(exerciseName != null){
        workouts = workoutsRepository.findByExerciseName(exerciseName);
        if(workouts.isEmpty()){
            return ResponseEntity.badRequest().body(workouts);
        } return ResponseEntity.ok(workouts);
    } workouts = workoutsRepository.findAll();
    return ResponseEntity.ok(workouts);
    }
}

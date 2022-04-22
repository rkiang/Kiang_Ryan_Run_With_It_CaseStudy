package com.optum.runwithitapp;

import com.optum.runwithitapp.Goals.GoalsController;
import com.optum.runwithitapp.Profile.ProfileController;
import com.optum.runwithitapp.Profile.ProfileService;
import com.optum.runwithitapp.Security.UserController;
import com.optum.runwithitapp.Security.UserService;
import com.optum.runwithitapp.Workouts.WorkoutsController;
import com.optum.runwithitapp.Goals.GoalsService;
import com.optum.runwithitapp.Workouts.WorkoutsService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KiangRyanRunWithItCaseStudyApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(KiangRyanRunWithItCaseStudyApplication.class, args);
        UserService userService = applicationContext.getBean(UserService.class);
        GoalsService goalsService = applicationContext.getBean(GoalsService.class);
        WorkoutsService workoutsService = applicationContext.getBean(WorkoutsService.class);
        UserController usersController = applicationContext.getBean(UserController.class);
        GoalsController goalsController = applicationContext.getBean(GoalsController.class);
        WorkoutsController workoutsController = applicationContext.getBean(WorkoutsController.class);
        applicationContext.getBean(MainController.class);
        applicationContext.getBean(ProfileService.class);
        applicationContext.getBean(ProfileController.class);

        if (userService != null) {
            System.out.println("userService: " + userService);
        }
//		if(usersController!=null){
//			System.out.println("usersController: " + usersController);
//		}

        if (goalsService != null) {
            System.out.println("userGoalsService: " + goalsService);
        }
        if (goalsController != null) {
            System.out.println("userGoalsController: " + goalsController);
        }
        if (workoutsService != null) {
            System.out.println("workoutsService: " + workoutsService);
        }
        if (workoutsController != null) {
            System.out.println("workoutsController: " + workoutsController);
        }
    }


    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> System.out.println("This app has started");
    }

}

package com.optum.runwithitapp;

import com.optum.runwithitapp.Exercises.ExercisesController;
import com.optum.runwithitapp.Goals.UserGoalsController;
//import com.optum.runwithitapp.Security.UsersController;
import com.optum.runwithitapp.Security.UsersController;
import com.optum.runwithitapp.Workouts.WorkoutsController;
import com.optum.runwithitapp.Exercises.ExerciseService;
import com.optum.runwithitapp.Goals.UserGoalsService;
import com.optum.runwithitapp.Security.UserService;
import com.optum.runwithitapp.Workouts.WorkoutsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class KiangRyanRunWithItCaseStudyApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(KiangRyanRunWithItCaseStudyApplication.class, args);
		UserService userService = applicationContext.getBean(UserService.class);
		ExerciseService exerciseService = applicationContext.getBean(ExerciseService.class);
		UserGoalsService userGoalsService = applicationContext.getBean(UserGoalsService.class);
		WorkoutsService workoutsService = applicationContext.getBean(WorkoutsService.class);
		UsersController usersController = applicationContext.getBean(UsersController.class);
		ExercisesController exerciseController = applicationContext.getBean(ExercisesController.class);
		UserGoalsController userGoalsController = applicationContext.getBean(UserGoalsController.class);
		WorkoutsController workoutsController = applicationContext.getBean(WorkoutsController.class);
		applicationContext.getBean(MainController.class);

		if(userService!=null){
			System.out.println("userService: "+userService);
		}
		if(usersController!=null){
			System.out.println("usersController: " + usersController);
		}

		if(exerciseService!=null){
			System.out.println("exercise: " + exerciseService);
		}
		if(exerciseController!=null){
			System.out.println("exerciseController: "+exerciseController);
		}

		if(userGoalsService!=null){
			System.out.println("userGoalsService: " + userGoalsService);
		}
		if(userGoalsController!=null){
			System.out.println("userGoalsController: "+userGoalsController);
		}
		if(workoutsService!=null){
			System.out.println("workoutsService: " + workoutsService);
		}
		if(workoutsController!=null){
			System.out.println("workoutsController: "+workoutsController);
		}
	}

}

package com.optum.runwithitapp;

import com.optum.runwithitapp.Controllers.ExercisesController;
import com.optum.runwithitapp.Controllers.UserGoalsController;
import com.optum.runwithitapp.Controllers.UsersController;
import com.optum.runwithitapp.Controllers.WorkoutsController;
import com.optum.runwithitapp.Services.ExerciseService;
import com.optum.runwithitapp.Services.UserGoalsService;
import com.optum.runwithitapp.Services.UserService;
import com.optum.runwithitapp.Services.WorkoutsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
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

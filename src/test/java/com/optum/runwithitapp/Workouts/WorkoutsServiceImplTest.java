package com.optum.runwithitapp.Workouts;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WorkoutsServiceImplTest {

    @Autowired
    private WorkoutsService workoutsService;

    @Test
    void getAllWorkouts() {
        List<Workouts> allWorkouts = workoutsService.getAllWorkouts();
        int sizeBeforeAddingWorkouts = allWorkouts.size();

        Workouts workoutsTest = new Workouts();
        workoutsTest.setExerciseName("Pushups");
        workoutsTest.setExerciseType("Weights");
        workoutsTest.setSets(4);
        workoutsTest.setReps(5);
        workoutsTest.setWeightAmount(42);
        workoutsService.saveWorkouts(workoutsTest);
        int sizeAfterAddingWorkouts = workoutsService.getAllWorkouts().size();

        Assertions.assertThat(sizeAfterAddingWorkouts).isEqualTo(sizeBeforeAddingWorkouts+1);
        Assertions.assertThat(allWorkouts.contains(workoutsTest));
    }

    @Test
    void saveWorkouts() {
    }

    @Test
    void getWorkoutsById() {
        List<Workouts> allWorkouts = workoutsService.getAllWorkouts();
        Workouts workoutsById = allWorkouts.get(0);
        if (workoutsById != null) {
            Workouts workoutsById2 = workoutsService.getWorkoutsById(workoutsById.getId());
            Assertions.assertThat(workoutsById).isEqualTo(workoutsById2);
        }
    }

    @Test
    void deleteWorkoutsById() {
    }

    @Test
    void getWorkoutsByExerciseName() {
    }
}
package com.optum.runwithitapp.Workouts;

import java.util.Date;
import java.util.List;

public interface WorkoutsService {
    List<Workouts> getAllWorkouts();

    void saveWorkouts(Workouts workouts);

    Workouts getWorkoutsById(long id);

    void deleteWorkoutsById(long id);

    List<Workouts> getWorkoutsByExerciseName(String suffix);
}

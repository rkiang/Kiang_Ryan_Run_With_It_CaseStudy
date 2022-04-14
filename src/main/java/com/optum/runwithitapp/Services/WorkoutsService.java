package com.optum.runwithitapp.Services;

import com.optum.runwithitapp.Models.Workouts;

import java.util.List;

public interface WorkoutsService {
    List<Workouts> getAllWorkouts();

    void saveWorkouts(Workouts workouts);

    Workouts getWorkoutsById(long id);

    void deleteWorkoutsById(long id);
}

package com.optum.runwithitapp.Services;

import com.optum.runwithitapp.Models.Exercise;

import java.util.List;

public interface ExerciseService {
    List<Exercise> getAllExercises();

    void saveExercises(Exercise exercises);

    Exercise getExercisesById(long id);

    void deleteExercisesById(long id);
}

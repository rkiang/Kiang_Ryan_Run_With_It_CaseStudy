package com.optum.runwithitapp.Services;

import com.optum.runwithitapp.Models.Exercises;

import java.util.List;

public interface ExerciseService {
    List<Exercises> getAllExercises();

    void saveExercises(Exercises exercises);

    Exercises getExercisesById(long id);

    void deleteExercisesById(long id);

}

package com.optum.runwithitapp.Exercises;

import com.optum.runwithitapp.Exercises.Exercises;

import java.util.List;

public interface ExerciseService {
    List<Exercises> getAllExercises();

    void saveExercises(Exercises exercises);

    Exercises getExercisesById(long id);

    void deleteExercisesById(long id);

}

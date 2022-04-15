package com.optum.runwithitapp.Exercises;

import com.optum.runwithitapp.Exercises.Exercises;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercises, Long> {
    Exercises findExercisesById(long id);
}

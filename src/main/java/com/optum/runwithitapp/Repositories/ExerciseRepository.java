package com.optum.runwithitapp.Repositories;

import com.optum.runwithitapp.Models.Exercises;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercises, Long> {
    Exercises findExercisesById(long id);
}

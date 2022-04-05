package com.optum.runwithitapp.Repositories;

import com.optum.runwithitapp.Models.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    Exercise findExercisesById(long id);
}

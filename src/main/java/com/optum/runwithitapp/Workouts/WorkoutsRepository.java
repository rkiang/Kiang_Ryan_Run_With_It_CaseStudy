package com.optum.runwithitapp.Workouts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface WorkoutsRepository extends JpaRepository<Workouts, Long> {
    Workouts findWorkoutsById(long id);

    List<Workouts> findByExerciseName(String suffix);
}

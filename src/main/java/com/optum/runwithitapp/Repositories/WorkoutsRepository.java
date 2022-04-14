package com.optum.runwithitapp.Repositories;

import com.optum.runwithitapp.Models.Workouts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutsRepository extends JpaRepository<Workouts, Long> {
    Workouts findWorkoutsById(long id);

}

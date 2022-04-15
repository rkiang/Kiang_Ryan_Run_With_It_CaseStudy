package com.optum.runwithitapp.Repositories;

import com.optum.runwithitapp.Goals.UserGoals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGoalRepository extends JpaRepository<UserGoals, Long> {
    UserGoals findUserGoalsById(long id);
}

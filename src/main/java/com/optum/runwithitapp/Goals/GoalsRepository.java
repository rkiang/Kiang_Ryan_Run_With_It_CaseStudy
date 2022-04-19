package com.optum.runwithitapp.Goals;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalsRepository extends JpaRepository<Goals, Long> {//    Goals findUserGoalsById(long id);
}

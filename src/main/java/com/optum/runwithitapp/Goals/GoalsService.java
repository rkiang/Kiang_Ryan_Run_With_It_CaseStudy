package com.optum.runwithitapp.Goals;

import java.util.List;

public interface GoalsService {
    List<Goals> getAllUserGoals();


    void saveUserGoals(Goals goals);

    Goals getUserGoalsById(long id);

    void deleteUserGoalsById(long id);
}

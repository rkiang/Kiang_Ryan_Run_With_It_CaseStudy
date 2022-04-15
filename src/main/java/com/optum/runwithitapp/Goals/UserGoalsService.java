package com.optum.runwithitapp.Goals;

import com.optum.runwithitapp.Goals.UserGoals;

import java.util.List;

public interface UserGoalsService {
    List<UserGoals> getAllUserGoals();

    void saveUserGoals(UserGoals userGoals);

    UserGoals getUserGoalsById(long id);

    void deleteUserGoalsById(long id);
}

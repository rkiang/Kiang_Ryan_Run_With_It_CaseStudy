package com.optum.runwithitapp.Services;

import com.optum.runwithitapp.Models.UserGoals;

import java.util.List;

public interface UserGoalsService {
    List<UserGoals> getAllUserGoals();

    void saveUserGoals(UserGoals userGoals);

    UserGoals getUserGoalsById(long id);

    void deleteUserGoalsById(long id);
}

package com.optum.runwithitapp.Goals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGoalsServiceImpl implements UserGoalsService{
    private UserGoalRepository userGoalRepository;

    @Autowired
    public UserGoalsServiceImpl(UserGoalRepository userGoalRepository){
        this.userGoalRepository = userGoalRepository;
    }

    @Override
    public List<UserGoals> getAllUserGoals() {
        return userGoalRepository.findAll();
    }

    @Override
    public void saveUserGoals(UserGoals userGoals) {
        userGoalRepository.save(userGoals);
    }

    @Override
    public UserGoals getUserGoalsById(long id) {
        UserGoals userGoals = userGoalRepository.getById(id);
        if(userGoals == null){
            try{
                throw new UserGoalsNotFoundException();
            } catch (UserGoalsNotFoundException e){
                e.printStackTrace();
            }
        } return userGoals;
    }

    @Override
    public void deleteUserGoalsById(long id) {
        userGoalRepository.deleteById(id);

    }
}

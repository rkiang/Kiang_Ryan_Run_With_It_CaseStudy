package com.optum.runwithitapp.Goals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalsServiceImpl implements GoalsService {
    private GoalsRepository goalsRepository;

    @Autowired
    public GoalsServiceImpl(GoalsRepository goalsRepository){
        this.goalsRepository = goalsRepository;
    }

    @Override
    public List<Goals> getAllUserGoals() {
        return goalsRepository.findAll();
    }

    @Override
    public void saveUserGoals(Goals goals) {
        goalsRepository.save(goals);
    }

    @Override
    public Goals getUserGoalsById(long id) {
        Goals goals = goalsRepository.getById(id);
        if(goals == null){
            try{
                throw new GoalsNotFoundException();
            } catch (GoalsNotFoundException e){
                e.printStackTrace();
            }
        } return goals;
    }

    @Override
    public void deleteUserGoalsById(long id) {
        goalsRepository.deleteById(id);

    }
}

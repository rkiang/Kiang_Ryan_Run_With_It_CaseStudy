package com.optum.runwithitapp.Services;

import com.optum.runwithitapp.Models.Workouts;
import com.optum.runwithitapp.Repositories.WorkoutsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutsServiceImpl implements WorkoutsService{

    private WorkoutsRepository workoutsRepository;

    @Autowired
    public WorkoutsServiceImpl(WorkoutsRepository workoutsRepository) {
        this.workoutsRepository = workoutsRepository;
    }

    @Override
    public List<Workouts> getAllWorkouts() {
        return workoutsRepository.findAll();
    }

    @Override
    public void saveWorkouts(Workouts workouts) {
        workoutsRepository.save(workouts);

    }

    @Override
    public Workouts getWorkoutsById(long id) {
        Workouts workouts = workoutsRepository.getById(id);
        if(workouts == null){
            try{
                throw new WorkoutsNotFoundException();
            } catch (WorkoutsNotFoundException e){
                e.printStackTrace();
            }
        }
        return workouts;
    }

    @Override
    public void deleteWorkoutsById(long id) {
        workoutsRepository.deleteById(id);
    }
}

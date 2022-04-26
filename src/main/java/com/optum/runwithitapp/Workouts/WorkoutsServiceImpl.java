package com.optum.runwithitapp.Workouts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WorkoutsServiceImpl implements WorkoutsService{

    private WorkoutsRepository workoutsRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

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
        LOGGER.info("!!!DATA FROM WORKOUTS TO DATABASE!!!");

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

    @Override
    public List<Workouts> getWorkoutsByExerciseName(String suffix) {
        return workoutsRepository.findByExerciseName(suffix);
    }
}

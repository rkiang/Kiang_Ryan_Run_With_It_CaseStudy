package com.optum.runwithitapp.Services;

import com.optum.runwithitapp.Models.Exercise;
import com.optum.runwithitapp.Repositories.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService{
    private ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseServiceImpl(ExerciseRepository exerciseRepository){
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public List<Exercise> getAllExercises() {
        return exerciseRepository.findAll();
    }

    @Override
    public void saveExercises(Exercise exercise) {
        exerciseRepository.save(exercise);
    }

    @Override
    public Exercise getExercisesById(long id) {
        Exercise exercise = exerciseRepository.getById(id);
        if(exercise == null);
        try{
            throw new ExerciseNotFoundException();
        } catch (ExerciseNotFoundException e) {
            e.printStackTrace();
        }return exercise;
    }

    @Override
    public void deleteExercisesById(long id) {
        exerciseRepository.deleteById(id);
    }
}

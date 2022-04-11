package com.optum.runwithitapp.Services;

import com.optum.runwithitapp.Models.Exercises;
import com.optum.runwithitapp.Repositories.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExercisesServiceImpl implements ExerciseService{
    private ExerciseRepository exerciseRepository;

    @Autowired
    public ExercisesServiceImpl(ExerciseRepository exerciseRepository){
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public List<Exercises> getAllExercises() {
        return exerciseRepository.findAll();
    }

    @Override
    public void saveExercises(Exercises exercises) {
        exerciseRepository.save(exercises);
    }

    @Override
    public Exercises getExercisesById(long id) {
        Exercises exercises = exerciseRepository.getById(id);
        if(exercises == null){
            try{
                throw new ExerciseNotFoundException();
            } catch (ExerciseNotFoundException e){
                e.printStackTrace();
            }
        }return exercises;
    }

    @Override
    public void deleteExercisesById(long id) {
        exerciseRepository.deleteById(id);
    }
}

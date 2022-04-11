package com.optum.runwithitapp.Models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class UserGoals {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "goalId", nullable = false)
    private long id;

    private long userId;

    private String goalExerciseName;

    private String goalExerciseType;

    private boolean completion;

    private int sets;

    private int reps;

    private int duration;

    private Date goalSet;

    private Date goalComplete;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getGoalExerciseName() {
        return goalExerciseName;
    }

    public void setGoalExerciseName(String goalExerciseName) {
        this.goalExerciseName = goalExerciseName;
    }

    public String getGoalExerciseType() {
        return goalExerciseType;
    }

    public void setGoalExerciseType(String goalExerciseType) {
        this.goalExerciseType = goalExerciseType;
    }

    public boolean isCompletion() {
        return completion;
    }

    public void setCompletion(boolean completion) {
        this.completion = completion;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getGoalSet() {
        return goalSet;
    }

    public void setGoalSet(Date goalSet) {
        this.goalSet = goalSet;
    }

    public Date getGoalComplete() {
        return goalComplete;
    }

    public void setGoalComplete(Date goalComplete) {
        this.goalComplete = goalComplete;
    }
}

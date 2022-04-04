package com.optum.runwithitapp.Models;


import javax.persistence.*;

@Entity
@Table(name= "exercises")
public class Exercises {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exerciseId", length = 50, nullable = false)
    private long id;

    @Column(name="exercise_name", length = 75, nullable = false)
    private String exerciseName;

    @Column(name="exercise_type", length= 50, nullable = false)
    private String exerciseType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(String exerciseType) {
        this.exerciseType = exerciseType;
    }
}

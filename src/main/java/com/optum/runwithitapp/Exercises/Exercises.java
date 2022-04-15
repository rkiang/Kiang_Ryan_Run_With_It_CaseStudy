package com.optum.runwithitapp.Exercises;

import javax.persistence.*;

@Entity
@Table(name = "exercises")
public class Exercises {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="exercise_id")
    private long id;
    @Column(name="exercise_name")
    private String exerciseName;
    @Column(name="exercise_type")
    private String exerciseType;

    private Integer reps;

    private Integer sets;

    private Integer weightAmount;

    private Integer duration;

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

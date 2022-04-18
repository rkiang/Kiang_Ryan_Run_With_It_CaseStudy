package com.optum.runwithitapp.Workouts;

import com.optum.runwithitapp.Security.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="workouts")
public class Workouts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String workoutName;

    private Date workoutDate;

    private String exerciseName;
    private String exerciseType;
    private Integer sets;
    private Integer reps;
    private Integer weightAmount;
    private Integer duration;

    @ManyToMany(targetEntity = User.class, fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<User> usersWorkouts;

    public Workouts() {
    }

    public Workouts(Long id, String workoutName, Date workoutDate,
                    String exerciseName, String exerciseType, Integer sets,
                    Integer reps, Integer weightAmount, Integer duration,
                    List<User> usersWorkouts) {
        this.id = id;
        this.workoutName = workoutName;
        this.workoutDate = workoutDate;
        this.exerciseName = exerciseName;
        this.exerciseType = exerciseType;
        this.sets = sets;
        this.reps = reps;
        this.weightAmount = weightAmount;
        this.duration = duration;
        this.usersWorkouts = usersWorkouts;
    }

    public List<User> getUsersWorkouts() {
        return usersWorkouts;
    }

    public void setUsersWorkouts(List<User> usersWorkouts) {
        this.usersWorkouts = usersWorkouts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWorkoutName() {
        return workoutName;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }

    public Date getWorkoutDate() {
        return workoutDate;
    }

    public void setWorkoutDate(Date workoutDate) {
        this.workoutDate = workoutDate;
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

    public Integer getSets() {
        return sets;
    }

    public void setSets(Integer sets) {
        this.sets = sets;
    }

    public Integer getReps() {
        return reps;
    }

    public void setReps(Integer reps) {
        this.reps = reps;
    }

    public Integer getWeightAmount() {
        return weightAmount;
    }

    public void setWeightAmount(Integer weightAmount) {
        this.weightAmount = weightAmount;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}

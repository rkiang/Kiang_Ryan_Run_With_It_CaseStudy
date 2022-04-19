package com.optum.runwithitapp.Goals;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "goals")
public class Goals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String goalName;

    private boolean completion = false;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date goalSet;

//    @DateTimeFormat(pattern="HH:mm")
//    @Temporal(TemporalType.TIME)
//    private Date kitchenReadyTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date goalCompleted;

    private String exerciseName;
    private String exerciseType;
    private Integer sets;
    private Integer reps;
    private Integer weightAmount;
    private Integer duration;

    public Goals() {
    }

//    @OneToMany(mappedBy = "goals", targetEntity = User.class, fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
//    private Set<User> user = new HashSet<>();


//    public Set<User> getUser() {
//        return user;
//    }
//
//    public void setUser(Set<User> user) {
//        this.user = user;
//    }


    public Goals(Long id, String goalName, boolean completion,
                 Date goalSet, Date goalCompleted, String exerciseName,
                 String exerciseType, Integer sets, Integer reps,
                 Integer weightAmount, Integer duration) {
        this.id = id;
        this.goalName = goalName;
        this.completion = completion;
        this.goalSet = goalSet;
        this.goalCompleted = goalCompleted;
        this.exerciseName = exerciseName;
        this.exerciseType = exerciseType;
        this.sets = sets;
        this.reps = reps;
        this.weightAmount = weightAmount;
        this.duration = duration;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public boolean isCompletion() {
        return completion;
    }

    public void setCompletion(boolean completion) {
        this.completion = completion;
    }

    public Date getGoalSet() {
        return goalSet;
    }

    public void setGoalSet(Date goalSet) {
        this.goalSet = goalSet;
    }

    public Date getGoalCompleted() {
        return goalCompleted;
    }

    public void setGoalCompleted(Date goalCompleted) {
        this.goalCompleted = goalCompleted;
    }
}

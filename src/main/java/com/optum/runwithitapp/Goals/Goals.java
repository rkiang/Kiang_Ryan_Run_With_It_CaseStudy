package com.optum.runwithitapp.Goals;

import com.optum.runwithitapp.Security.User;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "goals")
public class Goals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String goalName;

    private String status = "In Progress";

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date goalSet;

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

    public Goals(Long id, String goalName, String status,
                 Date goalSet, Date goalCompleted, String exerciseName,
                 String exerciseType, Integer sets, Integer reps,
                 Integer weightAmount, Integer duration) {
        this.id = id;
        this.goalName = goalName;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goals goals = (Goals) o;
        return Objects.equals(id, goals.id) && Objects.equals(goalName, goals.goalName) && Objects.equals(status, goals.status) && Objects.equals(goalSet, goals.goalSet) && Objects.equals(goalCompleted, goals.goalCompleted) && Objects.equals(exerciseName, goals.exerciseName) && Objects.equals(exerciseType, goals.exerciseType) && Objects.equals(sets, goals.sets) && Objects.equals(reps, goals.reps) && Objects.equals(weightAmount, goals.weightAmount) && Objects.equals(duration, goals.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, goalName, status, goalSet, goalCompleted, exerciseName, exerciseType, sets, reps, weightAmount, duration);
    }

    @Override
    public String toString() {
        return "Goals{" +
                "id=" + id +
                ", goalName='" + goalName + '\'' +
                ", status='" + status + '\'' +
                ", goalSet=" + goalSet +
                ", goalCompleted=" + goalCompleted +
                ", exerciseName='" + exerciseName + '\'' +
                ", exerciseType='" + exerciseType + '\'' +
                ", sets=" + sets +
                ", reps=" + reps +
                ", weightAmount=" + weightAmount +
                ", duration=" + duration +
                '}';
    }
}

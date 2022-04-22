package com.optum.runwithitapp.Workouts;

import com.optum.runwithitapp.Security.User;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="workouts")
public class Workouts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date workoutDate;

    private String exerciseName;
    private String exerciseType;
    private Integer sets;
    private Integer reps;
    private Integer weightAmount;
    @DateTimeFormat(pattern = "HH:mm")
    @Temporal(TemporalType.TIME)
    private Date duration;

    public Workouts() {
    }

    public Workouts(Long id,
                    Date workoutDate, String exerciseName,
                    String exerciseType, Integer sets,
                    Integer reps, Integer weightAmount,
                    Date duration) {
        this.id = id;
        this.workoutDate = workoutDate;
        this.exerciseName = exerciseName;
        this.exerciseType = exerciseType;
        this.sets = sets;
        this.reps = reps;
        this.weightAmount = weightAmount;
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getDuration() {
        return duration;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Workouts workouts = (Workouts) o;
        return Objects.equals(id, workouts.id) && Objects.equals(workoutDate, workouts.workoutDate) && Objects.equals(exerciseName, workouts.exerciseName) && Objects.equals(exerciseType, workouts.exerciseType) && Objects.equals(sets, workouts.sets) && Objects.equals(reps, workouts.reps) && Objects.equals(weightAmount, workouts.weightAmount) && Objects.equals(duration, workouts.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, workoutDate, exerciseName, exerciseType, sets, reps, weightAmount, duration);
    }

    @Override
    public String toString() {
        return "Workouts{" +
                "id=" + id +
                ", workoutDate=" + workoutDate +
                ", exerciseName='" + exerciseName + '\'' +
                ", exerciseType='" + exerciseType + '\'' +
                ", sets=" + sets +
                ", reps=" + reps +
                ", weightAmount=" + weightAmount +
                ", duration=" + duration +
                '}';
    }
}

package com.optum.runwithitapp.Models;

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

    @ManyToMany(targetEntity = User.class, fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<User> usersWorkouts;


    public Workouts(Long id, String workoutName, Date workoutDate, List<User> usersWorkouts) {
        this.id = id;
        this.workoutName = workoutName;
        this.workoutDate = workoutDate;
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
}

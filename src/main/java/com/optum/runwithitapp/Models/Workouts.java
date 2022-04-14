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

    @ManyToMany(targetEntity = Users.class, fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<Users> usersWorkouts;


    public Workouts(Long id, String workoutName, Date workoutDate, List<Users> usersWorkouts) {
        this.id = id;
        this.workoutName = workoutName;
        this.workoutDate = workoutDate;
        this.usersWorkouts = usersWorkouts;
    }

    public List<Users> getUsersWorkouts() {
        return usersWorkouts;
    }

    public void setUsersWorkouts(List<Users> usersWorkouts) {
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

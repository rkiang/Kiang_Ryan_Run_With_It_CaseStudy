package com.optum.runwithitapp.Goals;

import com.optum.runwithitapp.Security.User;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "goals")
public class UserGoals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String goalName;

    private boolean completion = false;

    private String goalSet;

    private String goalCompleted;

    public UserGoals() {
    }

    @OneToMany(mappedBy = "goals", targetEntity = User.class, fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private Set<User> user = new HashSet<>();
    public UserGoals(Long id, String goalName,
                     boolean completion, String goalSet, String goalCompleted) {
        this.id = id;
        this.goalName = goalName;
        this.completion = completion;
        this.goalSet = goalSet;
        this.goalCompleted = goalCompleted;
    }


    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
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

    public String getGoalSet() {
        return goalSet;
    }

    public void setGoalSet(String goalSet) {
        this.goalSet = goalSet;
    }

    public String getGoalCompleted() {
        return goalCompleted;
    }

    public void setGoalCompleted(String goalCompleted) {
        this.goalCompleted = goalCompleted;
    }
}

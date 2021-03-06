package com.optum.runwithitapp.Security;

import com.optum.runwithitapp.Goals.Goals;
import com.optum.runwithitapp.Profile.Profile;
import com.optum.runwithitapp.Workouts.Workouts;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @NotNull
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @OneToMany(targetEntity = Goals.class, fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private Set<Goals> goals = new HashSet<>();

    @OneToMany(targetEntity = Workouts.class, fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private Set<Workouts> workouts = new HashSet<>();

    @OneToMany(targetEntity = Profile.class, fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private Set<Profile> profile = new HashSet<>();

    public User(String firstName, String lastName,
                String email, String password, Set<Goals> goals,
                Set<Workouts> workouts, Set<Profile> profile,
                Collection<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.goals = goals;
        this.workouts = workouts;
        this.profile = profile;
        this.roles = roles;
    }

    public Set<Profile> getProfile() {
        return profile;
    }

    public void setProfile(Set<Profile> profile) {
        this.profile = profile;
    }

    public Set<Workouts> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(Set<Workouts> workouts) {
        this.workouts = workouts;
    }

    public Set<Goals> getGoals() {
        return goals;
    }

    public void setGoals(Set<Goals> goals) {
        this.goals = goals;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    public User() {
    }

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(goals, user.goals) && Objects.equals(workouts, user.workouts) && Objects.equals(profile, user.profile) && Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, password, goals, workouts, profile, roles);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", goals=" + goals +
                ", workouts=" + workouts +
                ", profile=" + profile +
                ", roles=" + roles +
                '}';
    }
}


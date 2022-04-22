package com.optum.runwithitapp.Profile;

import com.optum.runwithitapp.Security.User;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date weightDate;
    private Float weight;

    public Profile() {
    }

    public Profile(Long id, Date weightDate, Float weight) {
        this.id = id;
        this.weightDate = weightDate;
        this.weight = weight;
    }

    public Date getWeightDate() {
        return weightDate;
    }

    public void setWeightDate(Date weightDate) {
        this.weightDate = weightDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return Objects.equals(id, profile.id) && Objects.equals(weightDate, profile.weightDate) && Objects.equals(weight, profile.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, weightDate, weight);
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", weightDate=" + weightDate +
                ", weight=" + weight +
                '}';
    }
}

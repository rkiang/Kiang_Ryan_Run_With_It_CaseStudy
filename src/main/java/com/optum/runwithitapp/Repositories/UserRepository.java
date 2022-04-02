package com.optum.runwithitapp.Repositories;

import com.optum.runwithitapp.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findUsersById(long id);
}

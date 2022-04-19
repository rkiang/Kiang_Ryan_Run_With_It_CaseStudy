package com.optum.runwithitapp.Security;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    @NotNull
//    User findById(Long id);
    User findByEmail(String email);
}



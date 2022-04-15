package com.optum.runwithitapp.Security;

import com.optum.runwithitapp.Security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    Users findUsersById(long id);
    User findByUsername(String username);
}

package com.optum.runwithitapp.Security;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User saveUserInfo(User user);
    User findByEmail(String email);
    User save(UserRegistrationDto registration);

    List<User> getAllUsers();

    void deleteUsersById(long id);
}


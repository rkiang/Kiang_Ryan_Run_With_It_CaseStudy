package com.optum.runwithitapp.Security;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;
import java.util.List;

public interface UserService extends UserDetailsService {

    User saveUserInfo(User user);
    User findByEmail(String email);
    User save(UserRegistrationDto registration);

    List<User> getAllUsers();

    User getUserById(long id);

    void deleteUsersById(long id);
}


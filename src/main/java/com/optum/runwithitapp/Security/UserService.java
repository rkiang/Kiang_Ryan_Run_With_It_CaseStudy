package com.optum.runwithitapp.Security;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User saveUserInfo(User user);
    User findByEmail(String email);
    User save(UserRegistrationDto registration);
}


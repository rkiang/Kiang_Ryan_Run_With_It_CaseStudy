package com.optum.runwithitapp.Security;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByUsername(String username);
    User save(UserRegistrationDto registration);
}


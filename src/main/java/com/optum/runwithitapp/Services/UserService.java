package com.optum.runwithitapp.Services;

import com.optum.runwithitapp.Models.Users;
import com.optum.runwithitapp.Registration.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    Users findByUsername(String username);

    Users save(UserRegistrationDto registration);

    List<Users> getAllUsers();

    void saveUsers(Users users);

    Users getUsersById(long id);

    void deleteUsersById(long id);

}

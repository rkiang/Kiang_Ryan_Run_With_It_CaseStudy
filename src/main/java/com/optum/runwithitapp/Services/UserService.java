package com.optum.runwithitapp.Services;

import com.optum.runwithitapp.Models.User;
import com.optum.runwithitapp.Registration.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User findByUsername(String username);

    User save(UserRegistrationDto registration);

    List<User> getAllUsers();

    void saveUsers(User users);

    User getUsersById(long id);

    void deleteUsersById(long id);

}

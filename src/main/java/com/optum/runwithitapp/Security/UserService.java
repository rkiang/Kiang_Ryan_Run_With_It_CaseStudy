package com.optum.runwithitapp.Security;

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

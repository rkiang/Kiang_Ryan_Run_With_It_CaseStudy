package com.optum.runwithitapp.Services;

import com.optum.runwithitapp.Models.Users;

import java.util.List;

public interface UserService {

    List<Users> getAllUsers();

    void saveUsers(Users users);

    Users getUsersById(long id);

    void deleteUsersById(long id);

}

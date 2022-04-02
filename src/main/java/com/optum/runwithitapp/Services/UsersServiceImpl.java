package com.optum.runwithitapp.Services;

import com.optum.runwithitapp.Models.Users;
import com.optum.runwithitapp.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UserService{
    private UserRepository userRepository;

    @Autowired
    public UsersServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void saveUsers(Users users) {
        userRepository.save(users);
    }

    @Override
    public Users getUsersById(long id) {
        Users users = userRepository.getById(id);
        if(users == null){
            try{
                throw new UserNotFoundException();
            } catch (UserNotFoundException e) {
                e.printStackTrace();
            }
        } return users;
    }

    @Override
    public void deleteUsersById(long id) {
        userRepository.deleteById(id);
    }
}

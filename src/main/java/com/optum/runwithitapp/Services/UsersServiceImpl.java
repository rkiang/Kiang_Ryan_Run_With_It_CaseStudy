package com.optum.runwithitapp.Services;


import com.optum.runwithitapp.Models.Roles;
import com.optum.runwithitapp.Models.Users;
import com.optum.runwithitapp.Registration.UserRegistrationDto;
import com.optum.runwithitapp.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;


    public UsersServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Users findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Users save(UserRegistrationDto registration) {
        Users users = new Users();
        users.setUserName(registration.getUserName());
        users.setPassword(passwordEncoder.encode(registration.getPassword()));

        users.setRoles(Arrays.asList(new Roles("ROLE_USER")));
        return userRepository.save(users);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepository.findByUsername(username);
        if(users == null){
            throw new UsernameNotFoundException("Invalid username/password");
        }
        return new org.springframework.security.core.userdetails.User(users.getUserName(), users.getPassword(),
                mapRolesToAuthorities(users.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Roles> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
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

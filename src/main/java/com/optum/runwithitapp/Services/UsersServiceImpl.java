package com.optum.runwithitapp.Services;


import com.optum.runwithitapp.Models.Role;
import com.optum.runwithitapp.Models.User;
import com.optum.runwithitapp.Registration.UserRegistrationDto;
import com.optum.runwithitapp.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
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


    public UsersServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User save(UserRegistrationDto registration) {
        User users = new User();
        users.setUsername(registration.getUsername());
        users.setPassword(passwordEncoder.encode(registration.getPassword()));

        users.setRoles(Arrays.asList(new Role("ROLE_USER")));
        return userRepository.save(users);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User users = userRepository.findByUsername(username);
        if(users == null){
            throw new UsernameNotFoundException("Invalid username/password");
        }
        return new org.springframework.security.core.userdetails.User(users.getUsername(), users.getPassword(),
                mapRolesToAuthorities(users.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void saveUsers(User users) {
        userRepository.save(users);
    }

    @Override
    public User getUsersById(long id) {
        User users = userRepository.getById(id);
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

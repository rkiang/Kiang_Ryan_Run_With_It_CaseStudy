package com.optum.runwithitapp.Security;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    void saveUserInfo() {
    }

    @Test
    void getAllUsers() {
        List<User> allUsers = userService.getAllUsers();
        int sizeBeforeAdding = allUsers.size();
        User testUser = new User();
        testUser.setFirstName("Carl");
        testUser.setLastName("York");
        testUser.setEmail("cyork@email.com");
        userService.saveUserInfo(testUser);
        int sizeAfterAdding = userService.getAllUsers().size();

        Assertions.assertThat(sizeAfterAdding).isEqualTo(sizeBeforeAdding+1);
        Assertions.assertThat(allUsers.contains(testUser));
    }

    @Test
    void deleteUsersById() {
    }

    @Test
    void findByEmail() {

    }

    @Test
    void getUserById() {
        List<User> allUsers = userService.getAllUsers();
        User userTestId = allUsers.get(0);
        if(userTestId != null){
            User userById2 = userService.getUserById(userTestId.getId());
            Assertions.assertThat(userTestId).isEqualTo(userById2);
        }
    }

    @Test
    void save() {
    }

    @Test
    void loadUserByUsername() {
    }
}
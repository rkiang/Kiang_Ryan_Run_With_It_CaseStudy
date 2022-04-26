package com.optum.runwithitapp.Security;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void findByEmail_should_return_user_by_email_input(){
        User userTest = userRepository.findByEmail("admin@admin.com");
        Assertions.assertThat(userTest.getEmail()).isEqualTo("admin@admin.com");
    }
}
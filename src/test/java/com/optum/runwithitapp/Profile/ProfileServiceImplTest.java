package com.optum.runwithitapp.Profile;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProfileServiceImplTest {
    @Autowired
    private ProfileService profileService;

    @Test
    void getAllProfile() {
        List<Profile> allProfile = profileService.getAllProfile();
        int profileSizeBeforeAdding = allProfile.size();

        Profile profileTest = new Profile();
        profileTest.setWeight(43.53f);
        profileService.saveProfile(profileTest);
        int profileSizeAfterAdding = profileService.getAllProfile().size();

        Assertions.assertThat(profileSizeAfterAdding).isEqualTo(
                profileSizeBeforeAdding + 1);
        Assertions.assertThat(allProfile.contains(profileTest));
    }

    @Test
    void saveProfile() {
    }

    @Test
    void getProfileById() {
        List<Profile> allProfile = profileService.getAllProfile();
        Profile profileTestId = allProfile.get(0);
        if(profileTestId != null){
            Profile profileById2 = profileService.getProfileById(profileTestId.getId());
            Assertions.assertThat(profileTestId).isEqualTo(profileById2);
        }
    }

    @Test
    void deleteProfileById() {
    }
}
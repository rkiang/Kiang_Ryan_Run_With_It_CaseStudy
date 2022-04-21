package com.optum.runwithitapp.Profile;

import java.util.List;

public interface ProfileService {

    List<Profile> getAllProfile();

    void saveProfile(Profile profile);

    Profile getProfileById(long id);

    void deleteProfileById(long id);
}

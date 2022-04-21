package com.optum.runwithitapp.Profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    private ProfileRepository profileRepository;

    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public List<Profile> getAllProfile() {
        return profileRepository.findAll();
    }

    @Override
    public void saveProfile(Profile profile) {
        profileRepository.save(profile);
    }

    @Override
    public Profile getProfileById(long id) {
        Profile profile = profileRepository.getById(id);
        if(profile == null){
            try {
                throw new ProfileNotFoundException();
            } catch (ProfileNotFoundException e){
                e.printStackTrace();
            }
        } return profile;
    }

    @Override
    public void deleteProfileById(long id) {
        profileRepository.deleteById(id);
    }
}

package com.optum.runwithitapp.Profile;

import com.optum.runwithitapp.Security.User;
import com.optum.runwithitapp.Security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.Set;

@Controller
public class ProfileController {
    public ProfileService profileService;

    private UserService userService;

    @Autowired
    public ProfileController(ProfileService profileService, UserService userService) {
        this.profileService = profileService;
        this.userService = userService;
    }

    /*Retrieves user's profile info by searching for the logged in username/email. */
    @GetMapping("/profile")
    public String getProfile(Principal principal, Model model){
        User user = userService.findByEmail(principal.getName());
        model.addAttribute("username", principal.getName());
        Profile profile = new Profile();
        model.addAttribute("profile", profile);
        model.addAttribute("listProfile", user.getProfile());
        return "profile";
    }

    /*Allows user to post to profile page.*/
    @PostMapping("/createProfile/{email}")
    public String saveNewProfile(@PathVariable("email") String email,
                                 @ModelAttribute("profile") Profile profile){
        profileService.saveProfile(profile);
        User user = userService.findByEmail(email);
        user.getProfile().add(profile);
        userService.saveUserInfo(user);
        return "redirect:/profile";
    }

    @PostMapping("/updateProfile/{id}")
    public String updateProfile(@PathVariable("id") long id, Profile profile,
                                Model model){
        profileService.saveProfile(profile);
        return "redirect:/profile";
    }

    @GetMapping("/deleteProfile/{id}")
    public String deleteProfile(@PathVariable(value = "id") long id,
                                Principal principal){
        User user = userService.findByEmail(principal.getName());
        Set<Profile> profile = user.getProfile();
        Profile profileById = profileService.getProfileById(id);
        profile.remove(profileById);
        userService.saveUserInfo(user);
        this.profileService.deleteProfileById(id);
        return "redirect:/profile";
    }
}

package com.optum.runwithitapp.Controllers;


import com.optum.runwithitapp.Workouts.Workouts;
import com.optum.runwithitapp.Workouts.WorkoutsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class RestSecurityController {

    @GetMapping("/getNameOfLoggedInUser")
    public String getNameOfLoggedInUser(Principal principal) {
        return principal.getName();
    }

    @GetMapping("/getRolesOfLoggedInUser")
    public List<GrantedAuthority> getRolesOfLoggedInUser(Principal principal) {
        Collection<? extends GrantedAuthority> authorities
                = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>(authorities);
        return grantedAuthorities;
    }

}

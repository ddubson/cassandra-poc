package com.ddubson.filmfox.security;

import com.ddubson.filmfox.models.User;
import com.ddubson.filmfox.models.UserRole;
import com.ddubson.filmfox.repositories.UserRepository;
import com.ddubson.filmfox.repositories.UserRoleRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: ddubson
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserRoleRepository userRoleRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    Logger authLog;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user != null)
            authLog.info("Retrieved user " + user.getEmail());

        List<UserRole> userRoles = userRoleRepository.findRolesByEmail(email);
        if(userRoles != null && user != null) {
            authLog.info("Retrieved user roles for " + user.getEmail());
        }

        return new CustomUserDetails(user, userRoles);
    }
}

package com.ddubson.filmfox.security;

import com.ddubson.filmfox.models.User;
import com.ddubson.filmfox.models.UserRole;
import com.ddubson.filmfox.repositories.UserRepository;
import com.ddubson.filmfox.repositories.UserRoleRepository;
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

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(email);
        List<UserRole> userRoles=userRoleRepository.findRolesByEmail(email);
        return new CustomUserDetails(user,userRoles);
    }
}

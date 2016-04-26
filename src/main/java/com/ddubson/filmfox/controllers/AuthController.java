package com.ddubson.filmfox.controllers;

import com.ddubson.filmfox.models.User;
import com.ddubson.filmfox.security.CustomSecurityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: ddubson
 */
@RestController
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    CustomSecurityContext customSecurityContext;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(@RequestBody User user) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                user.getEmail(), user.getPassword());
        /*CustomUserDetails userDetails = new CustomUserDetails(user, userRole);
        userDetails.setEmail(user.getEmail());
        userDetails.setPassword(user.getPassword());
        token.setDetails(userDetails);*/

        Authentication auth = null;
        try {
            auth = authenticationManager.authenticate(token);
        } catch (BadCredentialsException e) {
            return "Email or password provided was incorrect.";
        }

        if (auth != null && auth.isAuthenticated()) {
            customSecurityContext.setAuthentication(auth);
            return "Successfully authenticated!";
        } else {
            return "Did not successfully authenticate.";
        }
    }

    @RequestMapping("/403")
    public String accessDenied() {
        return "Access Denied.";
    }
}

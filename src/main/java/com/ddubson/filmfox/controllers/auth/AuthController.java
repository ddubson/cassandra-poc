package com.ddubson.filmfox.controllers.auth;

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

    @RequestMapping("/403")
    public String accessDenied() {
        return "Access Denied.";
    }
}

package com.ddubson.filmfox.controllers.auth;

import com.ddubson.filmfox.security.CustomSecurityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.RequestMapping;
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

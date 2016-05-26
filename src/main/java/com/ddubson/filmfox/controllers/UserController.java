package com.ddubson.filmfox.controllers;

import com.ddubson.filmfox.models.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author: ddubson
 */
@RestController
public class UserController {
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUsers() {
        return null;
    }
}

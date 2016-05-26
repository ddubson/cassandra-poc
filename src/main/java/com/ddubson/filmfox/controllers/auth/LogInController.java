package com.ddubson.filmfox.controllers.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ddubson on 5/26/2016.
 */
@Controller
public class LogInController {
    @RequestMapping
    public String login() {
        // Return login.html thymeleaf template
        return "login";
    }
}

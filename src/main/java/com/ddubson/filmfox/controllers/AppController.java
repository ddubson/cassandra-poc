package com.ddubson.filmfox.controllers;

import com.ddubson.filmfox.security.CustomSecurityContext;
import com.ddubson.filmfox.services.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @Autowired
    CustomSecurityContext customSecurityContext;

    @Autowired
    MovieService movieService;

    @RequestMapping(value={"/home", "/"})
    public String homePage(Model model) {
        model.addAttribute("email", customSecurityContext.getCurrentUser());
        model.addAttribute("movies", movieService.getMovieSummaries());
        return "home";
    }
}

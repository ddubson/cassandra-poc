package com.ddubson.filmfox.controllers;

import com.ddubson.filmfox.models.Movie;
import com.ddubson.filmfox.models.MovieBuilder;
import com.ddubson.filmfox.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class AppController {
    @Autowired
    MovieService movieService;

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public List<Movie> listMovies() {
        return movieService.getMovieSummaries();
    }

    @RequestMapping(value = "/movies/{id}", method = RequestMethod.GET)
    public Movie getMovieById(@PathVariable("id") UUID id) {
        return movieService.getMovieById(id);
    }

    @RequestMapping(value = "/movies", method = RequestMethod.POST)
    public Movie addMovie(@RequestBody Movie movieJson) {
        MovieBuilder movieBuilder = new MovieBuilder()
                .movieName(movieJson.getName())
                .directedBy(movieJson.getDirectedBy())
                .yearReleased(movieJson.getYearReleased());
        return movieService.addMovie(movieBuilder);
    }
}

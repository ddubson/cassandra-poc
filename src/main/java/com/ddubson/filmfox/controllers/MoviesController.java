package com.ddubson.filmfox.controllers;

import com.ddubson.filmfox.models.Movie;
import com.ddubson.filmfox.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MoviesController {
    private MovieRepository movieRepository;

    @Autowired
    public MoviesController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/movies")
    public List<Movie> listMovies() {
        return movieRepository.findAll();
    }
}

package com.ddubson.filmfox.controllers;

import com.datastax.driver.core.utils.UUIDs;
import com.ddubson.filmfox.models.Movie;
import com.ddubson.filmfox.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ddubson on 1/23/16.
 */
@RestController
public class AppController {
    @Autowired
    MovieRepository movieRepository;

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public List<Movie> listMovies() {
        Iterable<Movie> movies = movieRepository.findAll();
        List<Movie> movieList = new ArrayList<>();
        movies.forEach(movieList::add);
        return movieList;
    }

    @RequestMapping(value = "/movies", method = RequestMethod.POST)
    public Movie addMovie(@RequestBody Movie movieJson) {
        Movie movie = new Movie();
        movie.setId(UUIDs.timeBased());
        movie.setDirectedBy(movieJson.getDirectedBy());
        movie.setName(movieJson.getName());
        movie.setYearReleased(movieJson.getYearReleased());
        movieRepository.save(movie);
        return movie;
    }
}

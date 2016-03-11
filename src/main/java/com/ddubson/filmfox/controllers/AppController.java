package com.ddubson.filmfox.controllers;

import com.datastax.driver.core.utils.UUIDs;
import com.ddubson.filmfox.models.Movie;
import com.ddubson.filmfox.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.repository.MapId;
import org.springframework.data.cassandra.repository.support.BasicMapId;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    @RequestMapping(value = "/movies/{id}", method = RequestMethod.GET)
    public Movie getMovieById(@PathVariable("id") UUID id) {
        MapId mapId = new BasicMapId();
        mapId.with("id", id);
        return movieRepository.findOne(mapId);
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

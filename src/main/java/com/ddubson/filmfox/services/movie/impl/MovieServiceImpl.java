package com.ddubson.filmfox.services.movie.impl;

import com.ddubson.filmfox.models.Movie;
import com.ddubson.filmfox.repositories.MovieRepository;
import com.ddubson.filmfox.services.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository movieRepository;

    @Override
    public List<Movie> getMovieSummaries() {
        return movieRepository.findAllMovieSummaries();
    }

    @Override
    public Movie getMovieById(UUID id) {
        return movieRepository.findOne(id);
    }

    @Override
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }
}

package com.ddubson.filmfox.services.impl;

import com.datastax.driver.core.utils.UUIDs;
import com.ddubson.filmfox.models.Movie;
import com.ddubson.filmfox.models.MovieBuilder;
import com.ddubson.filmfox.repositories.MovieRepository;
import com.ddubson.filmfox.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.repository.MapId;
import org.springframework.data.cassandra.repository.support.BasicMapId;

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
        return movieRepository.findOne(createMapId(id));
    }

    @Override
    public Movie addMovie(MovieBuilder movieBuilder) {
        Movie movie = movieBuilder.create();
        movie.setId(UUIDs.timeBased());
        return movieRepository.save(movie);
    }

    protected MapId createMapId(UUID id) {
        MapId mapId = new BasicMapId();
        mapId.with("id", id);
        return mapId;
    }
}

package com.ddubson.filmfox.services.movie;

import com.ddubson.filmfox.models.Movie;

import java.util.List;
import java.util.UUID;

public interface MovieService {
    List<Movie> getMovieSummaries();

    Movie getMovieById(UUID id);

    Movie addMovie(Movie movie);
}

package com.ddubson.filmfox.services.movie;

import com.ddubson.filmfox.models.Movie;
import com.ddubson.filmfox.models.MovieBuilder;

import java.util.List;
import java.util.UUID;

public interface MovieService {
    List<Movie> getMovieSummaries();

    Movie getMovieById(UUID id);

    Movie addMovie(MovieBuilder movieBuilder);
}

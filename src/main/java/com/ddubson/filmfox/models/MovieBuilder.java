package com.ddubson.filmfox.models;

/**
 * Created by ddubson on 3/16/16.
 */
public class MovieBuilder {
    Movie movie;

    public MovieBuilder() {
        movie = new Movie();
    }

    public MovieBuilder movieName(String movieName) {
        this.movie.setName(movieName);
        return this;
    }

    public MovieBuilder directedBy(String directedBy) {
        this.movie.setDirectedBy(directedBy);
        return this;
    }

    public MovieBuilder yearReleased(String yearReleased) {
        this.movie.setYearReleased(yearReleased);
        return this;
    }

    public Movie create() {
        return this.movie;
    }
}

package com.ddubson.filmfox.models;

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

    public MovieBuilder trailerLink(String trailerLink) {
        this.movie.setTrailerLink(trailerLink);
        return this;
    }

    public Movie create() {
        return this.movie;
    }
}

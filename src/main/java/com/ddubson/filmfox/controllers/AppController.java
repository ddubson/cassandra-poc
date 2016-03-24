package com.ddubson.filmfox.controllers;

import com.ddubson.filmfox.ElasticsearchClient;
import com.ddubson.filmfox.models.Movie;
import com.ddubson.filmfox.models.MovieBuilder;
import com.ddubson.filmfox.services.movie.MovieService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class AppController {
    @Autowired
    MovieService movieService;

    @Autowired
    ObjectMapper json;

    @Autowired
    ElasticsearchClient elasticsearchClient;

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

    @RequestMapping(value = "/sync", method = RequestMethod.GET)
    public IndexResponse sync() throws JsonProcessingException {
        IndexRequest indexRequest = new IndexRequest();

        Movie m = movieService.getMovieSummaries().get(0);
        IndexResponse r = elasticsearchClient.getElasticClient().prepareIndex(
                ElasticsearchClient.MOVIES_INDEX,
                ElasticsearchClient.MOVIES_TYPE,
                m.getId().toString())
                .setSource(json.writeValueAsBytes(m)).get();

        return r;
    }
}

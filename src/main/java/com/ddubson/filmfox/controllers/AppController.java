package com.ddubson.filmfox.controllers;

import com.ddubson.filmfox.ElasticsearchClient;
import com.ddubson.filmfox.exception.SearchResultsNotProcessedException;
import com.ddubson.filmfox.models.Movie;
import com.ddubson.filmfox.models.MovieBuilder;
import com.ddubson.filmfox.services.movie.MovieService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class AppController {
    @Autowired
    Logger sysLog;

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
                .yearReleased(movieJson.getYearReleased())
                .trailerLink(movieJson.getTrailerLink());
        return movieService.addMovie(movieBuilder);
    }

    @RequestMapping(value = "/movies/search", method = RequestMethod.POST)
    @ExceptionHandler(SearchResultsNotProcessedException.class)
    public List<Movie> search(@RequestBody String movieName) {
        SearchResponse searchResponse = elasticsearchClient.getElasticClient()
                .prepareSearch(ElasticsearchClient.MOVIES_INDEX)
                .setTypes(ElasticsearchClient.MOVIES_TYPE)
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.matchPhrasePrefixQuery("name", movieName))
                .execute().actionGet();

        List<Movie> movieSearchResults = new ArrayList<>();
        for (SearchHit hit : searchResponse.getHits().getHits()) {
            try {
                movieSearchResults.add(json.readValue(hit.getSourceAsString(), Movie.class));
            } catch (IOException e) {
                sysLog.error("Search results could not be processed.", e);
                throw new SearchResultsNotProcessedException("Search results could not be processed. This event has been logged.");
            }
        }

        //TODO catch 0 results
        //TODO paginate results
        if(movieSearchResults != null && movieSearchResults.size() > 0) {
            return movieSearchResults;
        } else
            throw new SearchResultsNotProcessedException("No movies found.");
    }
}

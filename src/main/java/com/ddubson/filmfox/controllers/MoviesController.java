package com.ddubson.filmfox.controllers;

import com.ddubson.filmfox.models.Movie;
import com.ddubson.filmfox.services.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class MoviesController {
    @Autowired
    MovieService movieService;

    @GetMapping("/movies")
    public List<Movie> listMovies() {
        return movieService.getMovieSummaries();
    }

    @RequestMapping(value = "/movies/{id}", method = RequestMethod.GET)
    public Movie getMovieById(@PathVariable("id") UUID id) {
        return movieService.getMovieById(id);
    }

    @RequestMapping(value = "/movies", method = RequestMethod.POST)
    public Movie addMovie(@RequestBody Movie movieJson) {
        Movie movie = Movie.builder()
                .name(movieJson.getName())
                .directedBy(movieJson.getDirectedBy())
                .yearReleased(movieJson.getYearReleased())
                .trailerLink(movieJson.getTrailerLink()).build();
        return movieService.addMovie(movie);
    }

    @PostMapping("/movies/search")
    //@ExceptionHandler(SearchResultsNotProcessedException.class)
    public ResponseEntity<?> search(@RequestBody String movieName) {
        /*SearchResponse searchResponse = elasticsearchClient.getElasticClient()
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
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Search results could not be processed. " +
                        "This event has been logged.");
            }
        }

        //TODO paginate results
        if (movieSearchResults.size() > 0) {
            return ResponseEntity.ok(movieSearchResults);
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No movies found.");*/

        return null;
    }
}

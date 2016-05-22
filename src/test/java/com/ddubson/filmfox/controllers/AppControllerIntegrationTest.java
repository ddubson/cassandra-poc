package com.ddubson.filmfox.controllers;

import com.ddubson.filmfox.models.Movie;
import com.ddubson.filmfox.services.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Author: ddubson
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(com.ddubson.filmfox.Application.class)
//@WebIntegrationTest
public class AppControllerIntegrationTest {
    RestTemplate template = new RestTemplate();

    @Autowired
    MovieService movieService;

    //@Test
    @SuppressWarnings("unchecked")
    public void test() {
        List<Movie> movies = (List<Movie>) template.getForObject("http://localhost:8080/movies", List.class);
        assertThat(movies.size(), equalTo(3));
    }
}

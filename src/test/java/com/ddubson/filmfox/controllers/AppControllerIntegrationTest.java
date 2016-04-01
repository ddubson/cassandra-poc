package com.ddubson.filmfox.controllers;

import com.ddubson.filmfox.models.Movie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Author: ddubson
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(com.ddubson.filmfox.Application.class)
@WebIntegrationTest
public class AppControllerIntegrationTest {
    RestTemplate template = new RestTemplate();

    @Test
    public void test() {
        List<Movie> movies = (List<Movie>) template.getForObject("http://localhost:8080/movies", List.class);
        assertThat(movies.size(), equalTo(3));
    }
}

package com.ddubson.filmfox.controllers;

import com.ddubson.filmfox.models.Movie;
import com.ddubson.filmfox.repositories.MovieRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MoviesController.class)
public class MoviesControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    MovieRepository movieRepository;

    @Test
    public void getMovieSummaries_ReturnsAllMovieSummaries() throws Exception {
        Movie movie1 = Movie.builder().id(1L).name("Movie1").directedBy("Director1").yearReleased("2000")
                .trailerLink("trailer").build();
        Movie movie2 = Movie.builder().id(2L).name("Movie2").directedBy("Director2").yearReleased("2001")
                .trailerLink("trailer2").build();
        List<Movie> movies = asList(movie1, movie2);

        when(movieRepository.findAll()).thenReturn(movies);

        mockMvc.perform(get("/movies")).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(movie1.getId().intValue()))
                .andExpect(jsonPath("$[0].name").value(movie1.getName()))
                .andExpect(jsonPath("$[0].directedBy").value(movie1.getDirectedBy()))
                .andExpect(jsonPath("$[0].yearReleased").value(movie1.getYearReleased()))
                .andExpect(jsonPath("$[0].trailerLink").value(movie1.getTrailerLink()))
                .andExpect(jsonPath("$[1].id").value(movie2.getId().intValue()))
                .andExpect(jsonPath("$[1].name").value(movie2.getName()))
                .andExpect(jsonPath("$[1].directedBy").value(movie2.getDirectedBy()))
                .andExpect(jsonPath("$[1].yearReleased").value(movie2.getYearReleased()))
                .andExpect(jsonPath("$[1].trailerLink").value(movie2.getTrailerLink()));
    }
}
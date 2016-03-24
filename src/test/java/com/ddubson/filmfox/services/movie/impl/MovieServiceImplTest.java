package com.ddubson.filmfox.services.movie.impl;

import com.datastax.driver.core.utils.UUIDs;
import com.ddubson.filmfox.models.Movie;
import com.ddubson.filmfox.models.MovieBuilder;
import com.ddubson.filmfox.repositories.MovieRepository;
import com.ddubson.filmfox.services.movie.MovieService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.cassandra.repository.MapId;
import org.springframework.data.cassandra.repository.support.BasicMapId;

import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by ddubson on 3/16/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class MovieServiceImplTest {
    @InjectMocks
    MovieService movieService = spy(new MovieServiceImpl());

    @Mock
    MovieRepository movieRepository = mock(MovieRepository.class);

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void movieServiceShouldFetchMovieByIdProperly() {
        Movie expectedMovie = mock(Movie.class);
        UUID uuid = UUIDs.random();
        doReturn(uuid).when(expectedMovie).getId();
        MapId mapId = new BasicMapId().with("id", uuid);
        doReturn(expectedMovie).when(movieRepository).findOne(mapId);

        Movie actualMovie = movieService.getMovieById(uuid);
        verify(movieRepository).findOne(any(MapId.class));
        assertThat(actualMovie, equalTo(expectedMovie));
    }

    @Test
    public void movieServiceShouldSaveMovieViaMovieRepository() {
        String movieName = "TEST_MOVIE";
        String directedBy = "TEST_DIRECTOR";
        String yearReleased = "2000";
        UUID uuid = UUIDs.random();
        Movie movie = mock(Movie.class);
        doReturn(directedBy).when(movie).getDirectedBy();
        doReturn(yearReleased).when(movie).getYearReleased();
        doReturn(movieName).when(movie).getName();
        doReturn(uuid).when(movie).getId();

        MovieBuilder movieBuilder = mock(MovieBuilder.class);
        doReturn(movie).when(movieBuilder).create();
        doReturn(movie).when(movieRepository).save(movie);

        Movie actualMovie = movieService.addMovie(movieBuilder);
        verify(movieRepository).save(movie);
        assertThat(actualMovie.getDirectedBy(), equalTo(directedBy));
        assertThat(actualMovie.getYearReleased(), equalTo(yearReleased));
        assertThat(actualMovie.getName(), equalTo(movieName));
        assertThat(actualMovie.getId(), equalTo(uuid));
    }
}
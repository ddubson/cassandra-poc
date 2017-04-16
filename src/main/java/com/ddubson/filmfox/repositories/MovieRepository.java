package com.ddubson.filmfox.repositories;

import com.ddubson.filmfox.models.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Created by ddubson on 3/7/16.
 */
@Repository
public interface MovieRepository extends CrudRepository<Movie, UUID> {
    @Query("select id, name, year_released, trailer_link from movies")
    List<Movie> findAllMovieSummaries();
}

package com.ddubson.filmfox.repositories;

import com.ddubson.filmfox.models.Movie;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ddubson on 3/7/16.
 */
@Repository
public interface MovieRepository extends CassandraRepository<Movie> {
    @Query("select id, name, year_released, trailer_link from movies")
    List<Movie> findAllMovieSummaries();
}

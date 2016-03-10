package com.ddubson.cassandra.v1.repositories;

import com.ddubson.cassandra.v1.models.Movie;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ddubson on 3/7/16.
 */
@Repository
public interface MovieRepository extends CassandraRepository<Movie> {
}

package com.ddubson.cassandra.v1.repositories;

import com.ddubson.cassandra.v1.models.Movie;
import org.springframework.data.cassandra.repository.CassandraRepository;

/**
 * Created by ddubson on 3/7/16.
 */
public interface MovieRepository extends CassandraRepository<Movie> {
}

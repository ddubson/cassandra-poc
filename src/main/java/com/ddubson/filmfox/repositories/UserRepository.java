package com.ddubson.filmfox.repositories;

import com.ddubson.filmfox.models.User;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Author: ddubson
 */
@Repository
public interface UserRepository extends CassandraRepository<User> {
    @Query("select * from users where email = ?1")
    User findUserByEmail(String email);
}

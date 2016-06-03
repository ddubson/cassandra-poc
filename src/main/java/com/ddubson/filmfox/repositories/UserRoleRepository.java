package com.ddubson.filmfox.repositories;

import com.ddubson.filmfox.models.UserRole;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: ddubson
 */
@Repository
public interface UserRoleRepository extends CassandraRepository<UserRole> {
    @Query("select * from users_roles where email = ?0")
    List<UserRole> findRolesByEmail(String email);
}

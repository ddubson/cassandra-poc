package com.ddubson.filmfox.repositories;

import com.ddubson.filmfox.models.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, UUID> {
    @Query(value = "select * from users_roles where email = ?0", nativeQuery = true)
    List<UserRole> findRolesByEmail(String email);
}

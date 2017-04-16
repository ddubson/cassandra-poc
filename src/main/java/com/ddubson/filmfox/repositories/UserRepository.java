package com.ddubson.filmfox.repositories;

import com.ddubson.filmfox.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {
    User findByEmail(String email);
}

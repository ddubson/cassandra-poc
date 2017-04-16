package com.ddubson.filmfox.models;


import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

/**
 * Author: ddubson
 */
@Entity
@Table(name="users_roles")
@Data
@Builder
public class UserRole {
    UUID id;
    String email;
    String role;
}

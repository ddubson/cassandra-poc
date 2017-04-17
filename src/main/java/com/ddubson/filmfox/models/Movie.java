package com.ddubson.filmfox.models;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="movies")
@Data
@Builder
public class Movie {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    UUID id;
    String name;
    @Column(name ="year_released")
    String yearReleased;
    @Column(name="directed_by")
    String directedBy;
    @Column(name="trailer_link")
    String trailerLink;
}

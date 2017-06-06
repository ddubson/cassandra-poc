package com.ddubson.filmfox.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="movies")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue
    Long id;
    String name;
    @Column(name ="year_released")
    String yearReleased;
    @Column(name="directed_by")
    String directedBy;
    @Column(name="trailer_link")
    String trailerLink;
}

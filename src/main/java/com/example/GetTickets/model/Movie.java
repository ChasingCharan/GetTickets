package com.example.GetTickets.model;


import com.example.GetTickets.Enum.Language;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Data
@Builder

public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int movieId;

    @Column(unique = true, nullable = false)
    String movieName;

    double duration;

    @Column(columnDefinition = "DATE",nullable = false)
    LocalDate releaseDate;

    @Enumerated(value = EnumType.STRING)
    Language language;

    double rating;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    @JsonIgnore
    List<Show> shows;
}

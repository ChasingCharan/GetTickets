package com.example.GetTickets.repository;

import com.example.GetTickets.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie,Integer> {
    boolean existsByMovieName(String movieName);

    Optional<Movie> findByMovieName(String movieName);
}

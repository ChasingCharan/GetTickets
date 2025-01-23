package com.example.GetTickets.repository;

import com.example.GetTickets.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TheaterRepository extends JpaRepository<Theater,Integer> {
    Optional<Theater> findByTheaterName(String theaterName);
}

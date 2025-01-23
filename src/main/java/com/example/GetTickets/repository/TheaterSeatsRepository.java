package com.example.GetTickets.repository;

import com.example.GetTickets.model.TheaterSeats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterSeatsRepository extends JpaRepository<TheaterSeats,Integer> {
}

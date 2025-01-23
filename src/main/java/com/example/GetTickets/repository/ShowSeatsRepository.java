package com.example.GetTickets.repository;

import com.example.GetTickets.model.ShowSeats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatsRepository extends JpaRepository<ShowSeats,Integer> {
}

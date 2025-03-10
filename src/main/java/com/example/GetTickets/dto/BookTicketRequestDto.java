package com.example.GetTickets.dto;

import com.example.GetTickets.Enum.SeatType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookTicketRequestDto {

    int UserId; // user UserId
    int showId;
    SeatType seatType;
    Set<String> requestedSeats;
}
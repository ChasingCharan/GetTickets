package com.example.GetTickets.transformer;

import com.example.GetTickets.Enum.SeatType;
import com.example.GetTickets.model.TheaterSeats;

public class TheaterSeatTransformer {
    public static TheaterSeats getTheaterSeat(String seatName, int rate, SeatType seatType) {
        return TheaterSeats.builder()
                .seatNumber(seatName)
                .rate(rate)
                .seatType(seatType)
                .build();
    }
}

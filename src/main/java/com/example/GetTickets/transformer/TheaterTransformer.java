package com.example.GetTickets.transformer;

import com.example.GetTickets.dto.request.TheaterRequest;
import com.example.GetTickets.dto.response.TheaterResponse;
import com.example.GetTickets.model.Theater;

public class TheaterTransformer {
    public static Theater theaterRequestToTheater(TheaterRequest theaterRequest) {
        return Theater.builder()
                .theaterName(theaterRequest.getName())
                .address(theaterRequest.getAddress())
                .type(theaterRequest.getType())
                .city(theaterRequest.getCity())
                .build();
    }

    public static TheaterResponse theaterToTheaterResponse(Theater theater) {
        return TheaterResponse.builder()
                .theaterName(theater.getTheaterName())
                .address(theater.getAddress())
                .city(theater.getCity())
                .type(theater.getType())
                .build();
    }
}

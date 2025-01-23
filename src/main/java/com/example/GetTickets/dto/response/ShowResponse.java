package com.example.GetTickets.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class ShowResponse {

    LocalDate showDate;

    LocalTime showTime;

    MovieResponse movieResponse;

    TheaterResponse theaterResponse;
}

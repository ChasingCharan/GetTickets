package com.example.GetTickets.dto.request;

import com.example.GetTickets.dto.response.MovieResponse;
import com.example.GetTickets.dto.response.TheaterResponse;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ShowRequest {
    int movieId;
    int theaterId;

}

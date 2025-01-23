package com.example.GetTickets.transformer;

import com.example.GetTickets.dto.request.ShowRequest;
import com.example.GetTickets.dto.response.MovieResponse;
import com.example.GetTickets.dto.response.ShowResponse;
import com.example.GetTickets.dto.response.TheaterResponse;
import com.example.GetTickets.model.Movie;
import com.example.GetTickets.model.Show;
import com.example.GetTickets.model.Theater;

import java.time.LocalDate;
import java.time.LocalTime;

public class ShowTransformer {
    public static Show showRequestToShow(ShowRequest showRequest, Movie movie, Theater theater) {
        return Show.builder()
                .showTime(LocalTime.now())
                .showDate(LocalDate.now())
                .movie(movie)
                .theater(theater)
                .build();
    }

    public static ShowResponse toResponse(Show savedShow) {

        return ShowResponse.builder()
                .showTime(savedShow.getShowTime())
                .showDate(savedShow.getShowDate())
                .movieResponse(MovieTransformer.movieToMovieResponse(savedShow.getMovie()))
                .theaterResponse(TheaterTransformer.theaterToTheaterResponse(savedShow.getTheater()))
                .build();
    }
}

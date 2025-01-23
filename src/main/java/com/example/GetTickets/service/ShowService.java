package com.example.GetTickets.service;

import com.example.GetTickets.dto.request.ShowRequest;
import com.example.GetTickets.dto.response.ShowResponse;
import com.example.GetTickets.model.*;
import com.example.GetTickets.repository.*;
import com.example.GetTickets.transformer.MovieTransformer;
import com.example.GetTickets.transformer.ShowTransformer;
import com.example.GetTickets.transformer.TheaterTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowService {
    private final MovieRepository movieRepository;
    private final TheaterSeatsRepository theaterSeatsRepository;
    private final ShowSeatsRepository showSeatsRepository;
    private final TheaterRepository theaterRepository;
    private  final ShowRepository showRepository;

    public ShowResponse addShow(ShowRequest showRequest) {

        Movie movie = movieRepository.findById(showRequest.getMovieId())
                .orElseThrow(() -> new RuntimeException("Movie not found"));
        Theater theater = theaterRepository.findById(showRequest.getTheaterId())
                .orElseThrow(() -> new RuntimeException("Theater not found"));


        Show show = ShowTransformer.showRequestToShow(showRequest,movie,theater);

        Show savedShow = showRepository.save(show);

        List<ShowSeats> showSeatsList = generateShowSeats(theater.getSeats(),savedShow);
        showSeatsRepository.saveAll(showSeatsList);

        ShowResponse showResponse = ShowTransformer.toResponse(savedShow);
        return showResponse;

    }

    public List<ShowSeats> generateShowSeats(List<TheaterSeats> seats, Show show) {
        List<ShowSeats> showSeatsList = new ArrayList<>();

        for(TheaterSeats theaterSeats : seats){
            ShowSeats showSeats = ShowSeats.builder()
                    .seatNumber(theaterSeats.getSeatNumber())
                    .seatType(theaterSeats.getSeatType())
                    .rate(theaterSeats.getRate())
                    .build();
            showSeatsList.add(showSeats);
        }

        for(ShowSeats showSeats : showSeatsList){
            showSeats.setShow(show);
        }

        show.setSeats(showSeatsList);
        return showSeatsList;
    }
}

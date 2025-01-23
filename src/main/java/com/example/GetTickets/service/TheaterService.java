package com.example.GetTickets.service;

import com.example.GetTickets.Enum.SeatType;
import com.example.GetTickets.dto.request.TheaterRequest;
import com.example.GetTickets.model.Theater;
import com.example.GetTickets.model.TheaterSeats;
import com.example.GetTickets.repository.TheaterRepository;
import com.example.GetTickets.repository.TheaterSeatsRepository;
import com.example.GetTickets.transformer.TheaterSeatTransformer;
import com.example.GetTickets.transformer.TheaterTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TheaterService {

    private final TheaterRepository theaterRepository;
    private final TheaterSeatsRepository theaterSeatsRepository;

    public String addTheater(TheaterRequest theaterRequest) {
        Theater theater = TheaterTransformer.theaterRequestToTheater(theaterRequest);

        // create seats in theater
        List<TheaterSeats> seats = createTheaterSeats();

        theater.setSeats(seats);

        theater.setShows(null);

        for(TheaterSeats theaterSeats:seats){
            theaterSeats.setTheater(theater);
        }

        theater = theaterRepository.save(theater);
        theaterSeatsRepository.saveAll(seats);

        return theater.getTheaterName()+" Theater was Successfully Added.";
    }

    List<TheaterSeats> createTheaterSeats() {
        List<TheaterSeats> seats = new ArrayList<>();
        seats.add(TheaterSeatTransformer.getTheaterSeat("1A",100, SeatType.CLASSIC));
        seats.add(TheaterSeatTransformer.getTheaterSeat("1B",100, SeatType.CLASSIC));
        seats.add(TheaterSeatTransformer.getTheaterSeat("1C",100, SeatType.CLASSIC));
        seats.add(TheaterSeatTransformer.getTheaterSeat("1D",100, SeatType.CLASSIC));
        seats.add(TheaterSeatTransformer.getTheaterSeat("2A",100, SeatType.CLASSIC));
        seats.add(TheaterSeatTransformer.getTheaterSeat("2B",100, SeatType.CLASSIC));
        seats.add(TheaterSeatTransformer.getTheaterSeat("2C",100, SeatType.CLASSIC));
        seats.add(TheaterSeatTransformer.getTheaterSeat("2D",100, SeatType.CLASSIC));

        seats.add(TheaterSeatTransformer.getTheaterSeat("3A",300, SeatType.PREMIUM));
        seats.add(TheaterSeatTransformer.getTheaterSeat("3B",300, SeatType.PREMIUM));
        seats.add(TheaterSeatTransformer.getTheaterSeat("3C",300, SeatType.PREMIUM));
        seats.add(TheaterSeatTransformer.getTheaterSeat("3D",300, SeatType.PREMIUM));
        return seats;
    }

}

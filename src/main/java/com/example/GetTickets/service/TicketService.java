package com.example.GetTickets.service;

import com.example.GetTickets.dto.BookTicketRequestDto;
import com.example.GetTickets.dto.response.TicketResponse;
import com.example.GetTickets.model.Show;
import com.example.GetTickets.model.ShowSeats;
import com.example.GetTickets.model.Ticket;
import com.example.GetTickets.model.User;
import com.example.GetTickets.repository.ShowRepository;
import com.example.GetTickets.repository.TicketRepository;
import com.example.GetTickets.repository.UserRepository;
import com.example.GetTickets.transformer.TicketTransaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final UserRepository userRepository;
    private final ShowRepository showRepository;
    private final TicketRepository ticketRepository;

    public TicketResponse bookTicket(BookTicketRequestDto bookTicketRequestDto) {

        User user = userRepository.findById(bookTicketRequestDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + bookTicketRequestDto.getUserId()));
        Show show = showRepository.findById(bookTicketRequestDto.getShowId())
                .orElseThrow(() -> new RuntimeException("Show not found with ID: " + bookTicketRequestDto.getShowId()));

        Set<String> requestSeats = bookTicketRequestDto.getRequestedSeats();

        List<ShowSeats> showSeatsList = show.getSeats();
        List<ShowSeats> bookedSeats = new ArrayList<>();
        for(ShowSeats seat : showSeatsList){
            if(!seat.isBooked() && seat.getSeatType().equals(bookTicketRequestDto.getSeatType())&&requestSeats.contains(seat.getSeatNumber())){
                bookedSeats.add(seat);
            }
        }

        if(bookedSeats.size()!=requestSeats.size()){
            throw new RuntimeException("Seats are not available");
        }

        Ticket ticket = Ticket.builder()
                .user(user)
                .show(show)
                .seats(bookedSeats)
                .build();

        double amount =0;

        for(ShowSeats showSeats : bookedSeats){
            showSeats.setBooked(true);
            showSeats.setBookedAt(new Date());
            showSeats.setTicket(ticket);

            amount=amount+showSeats.getRate();
        }

        ticket.setBookedAt(new Date());
        ticket.setAllottedSeats(convertListOfSeatsEntityToString(bookedSeats));
        ticket.setAmount(amount);

        show.getTickets().add(ticket);

        user.getTicketEntities().add(ticket);

        ticket = ticketRepository.save(ticket);

        TicketResponse response = TicketTransaction.ticketToTicketResponse(ticket);

        return response;
    }

    private String convertListOfSeatsEntityToString(List<ShowSeats> bookedSeats) {

        String str = "";
        for(ShowSeats showSeats : bookedSeats){
            str=str+showSeats.getSeatNumber()+" ";
        }
        return  str;
    }

    public TicketResponse getTicketById(int id) {
        Ticket ticket = ticketRepository.findById(id).get();

        TicketResponse response = TicketTransaction.ticketToTicketResponse(ticket);
        return response;
    }
}

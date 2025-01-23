package com.example.GetTickets.transformer;

import com.example.GetTickets.dto.response.TicketResponse;
import com.example.GetTickets.model.Ticket;

public class TicketTransaction {

    public static TicketResponse ticketToTicketResponse(Ticket ticket) {
        return  TicketResponse.builder()
                .UserId(ticket.getId())
                .amount(ticket.getAmount())
                .AllocatedSeats(ticket.getAllottedSeats())
                .build();
    }
}

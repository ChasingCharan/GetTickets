package com.example.GetTickets.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketResponse {
    int UserId;
    String AllocatedSeats;
    double amount;
}

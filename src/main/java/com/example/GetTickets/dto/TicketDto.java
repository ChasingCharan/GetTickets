package com.example.GetTickets.dto;

import com.example.GetTickets.dto.response.ShowResponse;
import com.example.GetTickets.dto.response.UserResponse;
import jakarta.validation.constraints.NotNull;

public class TicketDto {

    int id;
    String allocatedSeat;
    double amount;
    ShowResponse showDto;
    @NotNull
    UserResponse userDto;
}

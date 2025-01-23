package com.example.GetTickets.dto.response;

import com.example.GetTickets.dto.TicketDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserResponse {
    int id;

    String name;

    long mobNo;
}

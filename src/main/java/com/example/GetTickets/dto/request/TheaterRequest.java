package com.example.GetTickets.dto.request;

import com.example.GetTickets.Enum.TheaterType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class TheaterRequest {

    String name;
    String address;
    String city;
    TheaterType type;
}

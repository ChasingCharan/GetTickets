package com.example.GetTickets.dto.response;

import com.example.GetTickets.Enum.TheaterType;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheaterResponse {
    String theaterName;
    String address;
    String city;
    TheaterType type;

}

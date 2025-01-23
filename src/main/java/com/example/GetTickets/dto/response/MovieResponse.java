package com.example.GetTickets.dto.response;

import com.example.GetTickets.Enum.Language;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieResponse {
    String movieName;
    Language language;
}

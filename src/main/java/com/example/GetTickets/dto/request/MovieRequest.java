package com.example.GetTickets.dto.request;

import com.example.GetTickets.Enum.Language;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MovieRequest {
    String movieName;
    double duration;
    LocalDate releaseDate;
    Language language;
    double rating;
}

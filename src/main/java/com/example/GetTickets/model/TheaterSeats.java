package com.example.GetTickets.model;

import com.example.GetTickets.Enum.SeatType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Entity
@Table(name = "theater_seats")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TheaterSeats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(nullable = false)
    String seatNumber;

    @Column(nullable = false)
    int rate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    SeatType seatType;

    @ManyToOne
    @JsonIgnore
    @JoinColumn
    Theater theater;




}

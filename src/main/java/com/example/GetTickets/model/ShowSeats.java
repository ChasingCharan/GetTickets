package com.example.GetTickets.model;


import com.example.GetTickets.Enum.SeatType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ShowSeats {
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

    @Column(columnDefinition = "bit(1) default 0", nullable = false)
    boolean booked;

    @Temporal(TemporalType.TIMESTAMP)
    Date bookedAt;

    @ManyToOne
    @JsonIgnore
    Show show;

    @ManyToOne
    @JsonIgnore
    Ticket ticket;
}

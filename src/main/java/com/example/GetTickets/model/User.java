package com.example.GetTickets.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "mobile",unique = true, nullable = false)
    long mobile;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL) //bidirectional mapping
    List<Ticket> ticketEntities;
}

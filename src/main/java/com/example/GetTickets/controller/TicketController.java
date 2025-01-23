package com.example.GetTickets.controller;

import com.example.GetTickets.dto.BookTicketRequestDto;
import com.example.GetTickets.dto.response.TicketResponse;
import com.example.GetTickets.service.TicketService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ticket")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;
    @PostMapping()
    public ResponseEntity addTicket(@RequestBody() BookTicketRequestDto bookTicketRequestDto){
        TicketResponse response = ticketService.bookTicket(bookTicketRequestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("get{ticket_id}")
    public ResponseEntity getTicketById(@RequestParam int id){
        TicketResponse response = ticketService.getTicketById(id);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
}

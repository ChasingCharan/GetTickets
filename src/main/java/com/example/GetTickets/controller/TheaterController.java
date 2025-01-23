package com.example.GetTickets.controller;

import com.example.GetTickets.dto.request.TheaterRequest;
import com.example.GetTickets.service.TheaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("theater")
@RequiredArgsConstructor
public class TheaterController {

    private final TheaterService theaterService;

    @PostMapping()
    public ResponseEntity addTheater(@RequestBody TheaterRequest theaterRequest){
        String response = theaterService.addTheater(theaterRequest);
        return new ResponseEntity(response, HttpStatus.OK);
    }

}

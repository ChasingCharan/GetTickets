package com.example.GetTickets.controller;

import com.example.GetTickets.dto.request.MovieRequest;
import com.example.GetTickets.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
    @PostMapping()
    public ResponseEntity<String> addMovie(@RequestBody MovieRequest movieRequest){
        String response = movieService.addMovie(movieRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}

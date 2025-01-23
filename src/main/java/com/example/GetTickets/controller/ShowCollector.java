package com.example.GetTickets.controller;

import com.example.GetTickets.dto.request.ShowRequest;
import com.example.GetTickets.dto.response.ShowResponse;
import com.example.GetTickets.service.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/shows")
@RequiredArgsConstructor
public class ShowCollector {

    private final ShowService showService;

    @PostMapping()
    public ResponseEntity addShow(@RequestBody ShowRequest showRequest){
        return new ResponseEntity(showService.addShow(showRequest), HttpStatus.OK);
    }




}

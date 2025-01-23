package com.example.GetTickets.controller;

import com.example.GetTickets.dto.request.UserRequest;
import com.example.GetTickets.dto.response.UserResponse;
import com.example.GetTickets.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity addUser(@RequestBody UserRequest userRequest){
        String response = userService.addUser(userRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("{userId}")
    public ResponseEntity getUser(@RequestParam int id){
        UserResponse response = userService.getUser(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

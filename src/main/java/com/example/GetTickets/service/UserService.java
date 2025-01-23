package com.example.GetTickets.service;
import com.example.GetTickets.dto.request.UserRequest;
import com.example.GetTickets.dto.response.UserResponse;
import com.example.GetTickets.model.User;
import com.example.GetTickets.repository.UserRepository;
import com.example.GetTickets.transformer.UserTransaction;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public String addUser(UserRequest userRequest) {
        User user = UserTransaction.userRequestToUser(userRequest);
        User saveUser = userRepository.save(user);
        return saveUser.getName()+" your was Successfully Created";
    }


    public UserResponse getUser(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
        UserResponse response = UserTransaction.userToUserResponse(user);
        return response;
    }
}

package com.example.GetTickets.transformer;

import com.example.GetTickets.dto.request.UserRequest;
import com.example.GetTickets.dto.response.UserResponse;
import com.example.GetTickets.model.User;

public class UserTransaction {
    public static User userRequestToUser(UserRequest userRequest) {
        return User.builder()
                .name(userRequest.getName())
                .mobile(userRequest.getMobNo())
                .build();
    }

    public static UserResponse userToUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .mobNo(user.getMobile())
                .build();
    }
}

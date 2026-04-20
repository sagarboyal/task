package com.main.task.service.impl;

import com.main.task.entity.User;
import com.main.task.payload.request.UserRequest;
import com.main.task.payload.response.UserResponse;
import com.main.task.repository.UserRepository;
import com.main.task.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponse createUser(UserRequest request) {
        User user = new User();
        user.setFirstName(request.getFirstname());
        user.setLastName(request.getLastname());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());

        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        user = userRepository.save(user);
        return toResponse(user);
    }

    private UserResponse toResponse(User user){
        return UserResponse.builder()
                .firstname(user.getFirstName())
                .lastname(user.getLastName())
                .email(user.getEmail())
                .create_at(user.getCreatedAt().toString())
                .update_at(user.getUpdatedAt().toString())
                .build();
    }
}

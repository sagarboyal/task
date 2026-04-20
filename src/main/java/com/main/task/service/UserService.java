package com.main.task.service;

import com.main.task.entity.User;
import com.main.task.payload.request.UserRequest;
import com.main.task.payload.response.UserResponse;

import java.util.Optional;

public interface UserService {
    UserResponse createUser(UserRequest request);
    Optional<User> findByEmail(String email);
}

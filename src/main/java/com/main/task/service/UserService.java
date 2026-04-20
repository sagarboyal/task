package com.main.task.service;

import com.main.task.payload.request.UserRequest;
import com.main.task.payload.response.UserResponse;

public interface UserService {
    UserResponse createUser(UserRequest request);
}

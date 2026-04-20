package com.main.task.payload.response;

import lombok.Builder;

@Builder
public record UserResponse(
        Integer Id,
        String firstname,
        String lastname,
        String email,
        String create_at,
        String update_at
        ) {
}

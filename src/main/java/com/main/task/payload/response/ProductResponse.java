package com.main.task.payload.response;

import lombok.Builder;

@Builder
public record ProductResponse(
        Integer productId,
        String name,
        String user_email,
        String create_at,
        String update_at
) {
}

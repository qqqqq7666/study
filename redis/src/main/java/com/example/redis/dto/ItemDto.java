package com.example.redis.dto;

import lombok.Builder;

import java.io.Serializable;

@Builder
public record ItemDto(
        String name,
        String description,
        Integer price
) implements Serializable {
}

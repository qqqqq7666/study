package com.example.redis.dto;

import lombok.Builder;

import java.io.Serializable;

@Builder
public record ItemOrderDto(
        String id,
        String itemName,
        Integer quantity,
        Long totalPrice,
        String status
) implements Serializable { }

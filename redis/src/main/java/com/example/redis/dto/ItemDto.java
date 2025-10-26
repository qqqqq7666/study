package com.example.redis.dto;

import com.example.redis.entity.Item;
import lombok.Builder;

import java.io.Serializable;

@Builder
public record ItemDto(
        String name,
        String description,
        Integer price
) implements Serializable {
    public static ItemDto fromEntity(Item item) {
        return ItemDto.builder()
                .name(item.getName())
                .description(item.getDescription())
                .price(item.getPrice())
                .build();
    }
}

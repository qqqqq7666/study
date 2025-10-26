package com.example.redis.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;


@Getter
@Setter
@Builder
// Entity 대신 RedisHash
@RedisHash("item")
public class Item {
    @Id
    private Long id;
    private String name;
    private String description;
    private Integer price;
}

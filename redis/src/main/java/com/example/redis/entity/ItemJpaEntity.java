package com.example.redis.entity;

import com.example.redis.dto.ItemDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "item")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ItemJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Integer price;

    @Builder
    public ItemJpaEntity(Long id, String name, String description, Integer price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public void update(ItemDto itemDto) {
        name = itemDto.name();
        description = itemDto.description();
        price = itemDto.price();
    }
}

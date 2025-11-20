package com.example.db_lock.product;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    @Version
    private Integer version;

    @Builder
    public Product(Long id, String name, Double price, Integer version) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.version = version;
    }
}

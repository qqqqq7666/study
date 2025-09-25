package com.sparta_msa.product.core.domain;

import com.sparta_msa.product.adapter.out.persistence.JpaProduct;
import com.sparta_msa.product.dto.ProductResponseDto;
import com.sparta_msa.product.dto.ProductUpdateDto;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class Product {
    private Long id;
    private String name;
    private Integer price;
    private Integer quantity;
    private ProductStatus status;

    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;

    public void updateProduct(ProductUpdateDto productUpdateDto) {
        name = productUpdateDto.name();
        price = productUpdateDto.price();
        quantity = productUpdateDto.quantity();
        status = productUpdateDto.status();
    }

    public void delete() {
        status = ProductStatus.삭제;
    }

    public void reduceQuantity(int quantity) {
        if(this.quantity - quantity < 0)
            throw new IllegalArgumentException("not enough stock");
        this.quantity -= quantity;
    }

    public JpaProduct toJpaEntity() {
        return JpaProduct.builder()
                .id(id)
                .name(name)
                .price(price)
                .quantity(quantity)
                .status(status)
                .createdAt(createdAt)
                .createdBy(createdBy)
                .updatedAt(updatedAt)
                .updatedBy(updatedBy)
                .build();
    }

    public ProductResponseDto toResponseDto() {
        return ProductResponseDto.builder()
                .name(name)
                .price(price)
                .quantity(quantity)
                .status(status)
                .build();
    }
}

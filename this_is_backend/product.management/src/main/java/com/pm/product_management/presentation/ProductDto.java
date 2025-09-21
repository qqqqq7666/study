package com.pm.product_management.presentation;

import com.pm.product_management.domain.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record ProductDto(Long id, @NotBlank String name, @NotNull Integer price, @NotNull Integer amount) {

    public Product toEntity() {
        return Product.builder()
                .id(id)
                .name(name)
                .price(price)
                .amount(amount)
                .build();
    }
}

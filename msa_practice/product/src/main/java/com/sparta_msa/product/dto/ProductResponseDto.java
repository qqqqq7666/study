package com.sparta_msa.product.dto;

import com.sparta_msa.product.core.domain.ProductStatus;
import lombok.Builder;

@Builder
public record ProductResponseDto(String name, Integer price, Integer quantity, ProductStatus status) {
}

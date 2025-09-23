package com.sparta_msa.product.dto;

import lombok.Builder;

@Builder
public record ProductResponseDto(String name, Integer price, Integer quantity) {
}

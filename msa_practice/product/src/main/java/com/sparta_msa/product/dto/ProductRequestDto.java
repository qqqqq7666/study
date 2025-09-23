package com.sparta_msa.product.dto;

import lombok.Builder;

@Builder
public record ProductRequestDto(String name, Integer price, Integer quantity) {
}

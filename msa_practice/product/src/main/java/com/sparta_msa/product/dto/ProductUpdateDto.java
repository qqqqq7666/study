package com.sparta_msa.product.dto;

import lombok.Builder;

@Builder
public record ProductUpdateDto(String name, Integer price, Integer quantity) {
}

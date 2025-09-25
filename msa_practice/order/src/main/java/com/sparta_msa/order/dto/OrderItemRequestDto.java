package com.sparta_msa.order.dto;

public record OrderItemRequestDto(Long productId, Integer quantity) {
}

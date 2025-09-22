package com.sparta_msa.order.dto;

import com.sparta_msa.order.core.domain.OrderStatus;
import lombok.Builder;

@Builder
public record OrderResponseDto(Long id, OrderStatus orderStatus, String memo) {
}

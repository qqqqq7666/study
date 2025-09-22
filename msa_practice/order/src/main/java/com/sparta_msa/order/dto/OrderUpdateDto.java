package com.sparta_msa.order.dto;

import com.sparta_msa.order.core.domain.OrderStatus;
import lombok.Builder;

@Builder
public record OrderUpdateDto(OrderStatus orderStatus, String memo) {
}

package com.sparta_msa.order.dto;

import com.sparta_msa.order.core.domain.OrderItem;
import lombok.Builder;

import java.util.List;

@Builder
public record OrderRequestDto(Long userId,
                              String memo,
                              List<OrderItemRequestDto> itemRequestList) { }

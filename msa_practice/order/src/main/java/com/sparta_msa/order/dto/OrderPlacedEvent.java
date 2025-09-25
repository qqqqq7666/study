package com.sparta_msa.order.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class OrderPlacedEvent {
    private List<OrderItemRequestDto> orderItemRequestDtoList;
}

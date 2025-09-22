package com.sparta_msa.order.core.port.in;

import com.sparta_msa.order.dto.OrderRequestDto;
import com.sparta_msa.order.dto.OrderResponseDto;
import org.springframework.http.ResponseEntity;

public interface OrderCreateUseCase {
    ResponseEntity<OrderResponseDto> createOrder(OrderRequestDto requestDto);
}

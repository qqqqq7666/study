package com.sparta_msa.order.core.port.in;

import com.sparta_msa.order.dto.OrderResponseDto;
import com.sparta_msa.order.dto.OrderUpdateDto;
import org.springframework.http.ResponseEntity;

public interface OrderUpdateUseCase {
    ResponseEntity<OrderResponseDto> updateOrderStatus(Long orderId, OrderUpdateDto updateDto);

    ResponseEntity<OrderResponseDto> removeOrder(Long orderId);
}

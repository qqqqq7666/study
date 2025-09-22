package com.sparta_msa.order.core.port.in;

import com.sparta_msa.order.dto.OrderResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface GetOrderUseCase {
    Page<OrderResponseDto> getOrderList(int pageNum);

    ResponseEntity<OrderResponseDto> getOrder(Long orderId);
}

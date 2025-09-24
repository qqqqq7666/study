package com.sparta_msa.order.adapter.in.web;

import com.sparta_msa.order.core.port.in.GetOrderUseCase;
import com.sparta_msa.order.core.port.in.OrderCreateUseCase;
import com.sparta_msa.order.core.port.in.OrderUpdateUseCase;
import com.sparta_msa.order.dto.OrderRequestDto;
import com.sparta_msa.order.dto.OrderResponseDto;
import com.sparta_msa.order.dto.OrderUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final OrderCreateUseCase orderCreateUseCase;
    private final OrderUpdateUseCase orderUpdateUseCase;
    private final GetOrderUseCase getOrderUseCase;

    @GetMapping
    public ResponseEntity<Page<OrderResponseDto>> getOrderList(@RequestParam int page) {
        return ResponseEntity.ok(getOrderUseCase.getOrderList(page));
    }

    @GetMapping("{orderId}")
    public ResponseEntity<OrderResponseDto> getOrder(@PathVariable Long orderId) {
        return getOrderUseCase.getOrder(orderId);
    }

    @PostMapping
    public ResponseEntity<OrderResponseDto> createOrder(@RequestBody OrderRequestDto requestDto) {
        return orderCreateUseCase.createOrder(requestDto);
    }

    @PatchMapping("/{orderId}")
    public ResponseEntity<OrderResponseDto> updateOrder(@PathVariable Long orderId, @RequestBody OrderUpdateDto updateDto) {
        return orderUpdateUseCase.updateOrderStatus(orderId, updateDto);
    }

    @PatchMapping("/delete/{orderId}")
    public ResponseEntity<OrderResponseDto> deleteOrder(@PathVariable Long orderId) {
        return orderUpdateUseCase.removeOrder(orderId);
    }
}

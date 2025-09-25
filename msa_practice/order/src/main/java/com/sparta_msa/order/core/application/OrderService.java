package com.sparta_msa.order.core.application;

import com.sparta_msa.order.core.domain.Order;
import com.sparta_msa.order.core.domain.OrderItem;
import com.sparta_msa.order.core.domain.OrderStatus;
import com.sparta_msa.order.core.port.in.GetOrderUseCase;
import com.sparta_msa.order.core.port.in.OrderCreateUseCase;
import com.sparta_msa.order.core.port.in.OrderUpdateUseCase;
import com.sparta_msa.order.core.port.out.LoadOrderPort;
import com.sparta_msa.order.core.port.out.SaveOrderPort;
import com.sparta_msa.order.dto.OrderItemRequestDto;
import com.sparta_msa.order.dto.OrderRequestDto;
import com.sparta_msa.order.dto.OrderResponseDto;
import com.sparta_msa.order.dto.OrderUpdateDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URI;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService implements OrderCreateUseCase, OrderUpdateUseCase, GetOrderUseCase {
    private final LoadOrderPort loadOrderPort;
    private final SaveOrderPort saveOrderPort;
    private final RabbitTemplate rabbitTemplate;

    private Order toOrderEntity(OrderRequestDto requestDto) {
        return Order.builder()
                .memo(requestDto.memo())
                .status(OrderStatus.상품_준비)
                .orderItemList(requestDto.itemRequestList()
                        .stream().map(this::toItemEntity).toList())
                .build();
    }

    private OrderItem toItemEntity(OrderItemRequestDto requestDto) {
        return OrderItem.builder()
                .productId(requestDto.productId())
                .quantity(requestDto.quantity())
                .build();
    }

    @Override
    @Transactional
    public ResponseEntity<OrderResponseDto> createOrder(OrderRequestDto requestDto) {
        Order order = saveOrderPort.saveOrder(toOrderEntity(requestDto));

        log.info("#### Order sending message: {}", requestDto.itemRequestList());
        rabbitTemplate.convertAndSend("order.exchange", "order.create", requestDto.itemRequestList());

        return ResponseEntity.created(URI.create("temp"))
                .body(order.toResponseDto());
    }

    @Override
    @Transactional
    public ResponseEntity<OrderResponseDto> updateOrderStatus(Long orderId, OrderUpdateDto updateDto) {
        Order order = loadOrderPort.loadOrderById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("invalid orderId"));

        order.updateStatus(updateDto.orderStatus());
        return  ResponseEntity.ok(order.toResponseDto());
    }

    @Override
    @Transactional
    public ResponseEntity<OrderResponseDto> removeOrder(Long orderId) {
        Order order = loadOrderPort.loadOrderById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("invalid orderId"));

        order.deleteOrder();
        return ResponseEntity.ok(order.toResponseDto());
    }

    @Override
    public Page<OrderResponseDto> getOrderList(int page) {
        Pageable pageable = Pageable.ofSize(10)
                .withPage(page);

        return new PageImpl<>(loadOrderPort.loadOrderList(pageable)
                .stream()
                .map(Order::toResponseDto)
                .toList());
    }

    @Override
    public ResponseEntity<OrderResponseDto> getOrder(Long orderId) {
        return ResponseEntity.ok(
                loadOrderPort.loadOrderById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("invalid orderId"))
                .toResponseDto());
    }
}

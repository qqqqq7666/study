package com.market.orderservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    @Value("${message.queue.product}")
    private String productQueue;

    private final RabbitTemplate rabbitTemplate;

    private Map<UUID, Order> orderStore = new HashMap<>();

    public Order createOrder(OrderRequest request) {
        Order order = request.toOrder();
        DeliveryMessage message = request.toDeliveryMessage(order.getOrderId());

        orderStore.put(order.getOrderId(), order);

        log.info("#### send message : {}", message.toString());

        rabbitTemplate.convertAndSend(productQueue, message);

        return orderStore.get(order.getOrderId());
    }

    public void rollbackOrder(DeliveryMessage message) {
        Order order = orderStore.get(message.orderId());
        order.cancelOrder(message.errorType());
        log.info("#### order : {}", order.toString());
    }

    public Order getOrder(UUID orderId) {
        return orderStore.get(orderId);
    }
}

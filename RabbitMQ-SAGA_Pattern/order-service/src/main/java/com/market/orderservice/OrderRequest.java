package com.market.orderservice;

import lombok.Builder;

import java.util.UUID;

@Builder
public record OrderRequest(
        String userId,
        Integer productId,
        Integer productQuantity,
        Integer payAmount
) {
    public Order toOrder() {
        return Order.builder()
                .orderId(UUID.randomUUID())
                .userId(userId)
                .orderStatus("RECEIPT")
                .build();
    }

    public DeliveryMessage toDeliveryMessage(UUID orderId) {
        return DeliveryMessage.builder()
                .orderId(orderId)
                .productId(productId)
                .productQuantity(productQuantity)
                .payAmount(payAmount)
                .build();
    }
}

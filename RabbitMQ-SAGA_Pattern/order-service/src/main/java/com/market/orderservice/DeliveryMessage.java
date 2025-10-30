package com.market.orderservice;

import lombok.Builder;

import java.util.UUID;

@Builder
public record DeliveryMessage(
        UUID orderId,
        UUID paymentId,
        String userId,
        Integer productId,
        Integer productQuantity,
        Integer payAmount,
        String errorType
) {
}

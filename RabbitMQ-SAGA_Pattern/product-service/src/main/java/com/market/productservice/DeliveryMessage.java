package com.market.productservice;

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
    public DeliveryMessage setErrorType(String errorType) {
        return DeliveryMessage.builder()
                .orderId(orderId)
                .paymentId(paymentId)
                .userId(userId)
                .productId(productId)
                .productQuantity(productQuantity)
                .payAmount(payAmount)
                .errorType(errorType)
                .build();
    }
}

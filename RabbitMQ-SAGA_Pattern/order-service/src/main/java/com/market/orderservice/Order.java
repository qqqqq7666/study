package com.market.orderservice;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Builder
@Getter
@ToString
public class Order {
    private UUID orderId;
    private String userId;
    private String orderStatus;
    private String errorType;

    public void cancelOrder(String receiveErrorType) {
        orderStatus = "CANCEL";
        errorType = receiveErrorType;
    }
}

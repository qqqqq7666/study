package com.market.productservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {
    private final RabbitTemplate rabbitTemplate;

    @Value("${message.queue.payment}")
    private String paymentQueue;

    @Value("${message.queue.err.order}")
    private String orderErrorQueue;

    public void reduceProductAmount(DeliveryMessage message) {
        Integer productId = message.productId();
        Integer productQuantity = message.productQuantity();

        if(productId != 1 || productQuantity > 1) {
            rollbackProduct(message);
            return;
        }

        rabbitTemplate.convertAndSend(paymentQueue, message);
    }

    public void rollbackProduct(DeliveryMessage message) {
        log.error("Product Rollback!!");
        if(!StringUtils.hasText(message.errorType()))
            message = message.setErrorType(message.errorType());

        rabbitTemplate.convertAndSend(orderErrorQueue, message);
    }
}

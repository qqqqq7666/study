package com.market.productservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProductEndpoint {
    private final ProductService productService;

    @RabbitListener(queues = "${message.queue.product}")
    public void receiveMessage(DeliveryMessage message) {
        productService.reduceProductAmount(message);

        log.info("#### product receive: {}", message.toString());
    }

    @RabbitListener(queues = "${message.queue.err.product}")
    public void receiveErrorMessage(DeliveryMessage message) {
        log.error("Error Receive !!!");

        productService.rollbackProduct(message);
    }
}

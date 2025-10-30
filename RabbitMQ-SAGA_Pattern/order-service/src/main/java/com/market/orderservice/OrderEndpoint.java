package com.market.orderservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderEndpoint {
    private final OrderService orderService;

    @GetMapping("{id}")
    public ResponseEntity<Order> getOrder(@PathVariable UUID id) {
        Order order = orderService.getOrder(id);
        return ResponseEntity.ok(order);
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest request) {
        Order order = orderService.createOrder(request);
        return ResponseEntity.created(URI.create("create"))
                .body(order);
    }

    @RabbitListener(queues = "${message.queue.err.order}")
    public void errOrder(DeliveryMessage message) {
        log.error("ORDER ERROR Receive");
        orderService.rollbackOrder(message);
    }

}

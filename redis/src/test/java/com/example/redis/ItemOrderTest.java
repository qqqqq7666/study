package com.example.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ItemOrderTest {
    @Autowired
    ItemOrderController controller;

    @Test
    void createTest() {
        ItemOrder itemOrder = ItemOrder.builder()
                .itemName("testName")
                .quantity(12)
                .totalPrice(100L)
                .status("주문 중")
                .build();
        System.out.println(controller.save(itemOrder).toString());
    }

    @Test
    void saveToRedisTest() {
        ItemOrderDto itemOrder = ItemOrderDto.builder()
                .itemName("testName")
                .quantity(12)
                .totalPrice(100L)
                .status("주문 중")
                .build();
        System.out.println(controller.saveToRedis(itemOrder).toString());
    }
}

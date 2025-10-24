package com.example.redis;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Builder
@ToString
@RedisHash("itemOrder")
public class ItemOrder {
    @Id
    private String id;
    private String itemName;
    private Integer quantity;
    private Long totalPrice;
    private String status;

    public void update(ItemOrder itemOrder) {
        this.itemName = itemOrder.getItemName();
        this.quantity = itemOrder.getQuantity();
        this.totalPrice = itemOrder.getTotalPrice();
        this.status = itemOrder.getStatus();
    }
}

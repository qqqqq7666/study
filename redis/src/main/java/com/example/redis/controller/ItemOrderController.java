package com.example.redis.controller;

import com.example.redis.entity.ItemOrder;
import com.example.redis.dto.ItemOrderDto;
import com.example.redis.service.ItemOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/item-orders")
public class ItemOrderController {
    private final ItemOrderService itemOrderService;

    @PostMapping
    public ResponseEntity<ItemOrder> save(ItemOrder itemOrder) {
        return ResponseEntity.created(URI.create("temp"))
                .body(itemOrderService.save(itemOrder));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemOrder> findById(@PathVariable String id) {
        return ResponseEntity.ok(itemOrderService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemOrder> update(@PathVariable String id, ItemOrder newItemOrder) {
        return ResponseEntity.ok(itemOrderService.update(id, newItemOrder));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        itemOrderService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/dto")
    public ResponseEntity<ItemOrderDto> saveToRedis(ItemOrderDto itemOrderDto) {
        return ResponseEntity.ok(itemOrderService.saveToRedis(itemOrderDto));
    }
}

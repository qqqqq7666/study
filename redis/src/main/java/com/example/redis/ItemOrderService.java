package com.example.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ItemOrderService {
    private final ItemOrderRepository itemOrderRepository;

    @Qualifier("itemOrderRedisTemplate")
    private final RedisTemplate itemOrderRedisTemplate;

    @Transactional
    public ItemOrder save(ItemOrder itemOrder) {
        return itemOrderRepository.save(itemOrder);
    }

    public ItemOrder findById(String id) {
        return itemOrderRepository.findById(id).orElseThrow();
    }

    @Transactional
    public ItemOrder update(String id, ItemOrder newItemOrder) {
        ItemOrder itemOrder = findById(id);
        itemOrder.update(newItemOrder);
        return itemOrder;
    }

    public void delete(String id) {
        itemOrderRepository.deleteById(id);
    }

    public ItemOrderDto saveToRedis(ItemOrderDto itemOrderDto) {
        ValueOperations<String, ItemOrderDto> ops = itemOrderRedisTemplate.opsForValue();

        ops.set("itemOrder", itemOrderDto);
        return ops.get("itemOrder");
    }
}

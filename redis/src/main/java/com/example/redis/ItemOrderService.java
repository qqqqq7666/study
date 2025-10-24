package com.example.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ItemOrderService {
    private final ItemOrderRepository itemOrderRepository;

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
}

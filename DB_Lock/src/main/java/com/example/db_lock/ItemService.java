package com.example.db_lock;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository repository;

    @Transactional
    public void save(Item item) {
        repository.save(item);
    }

    @Transactional
    public void updateQuantity(Long id, Integer quantity) {
        Item item = repository.findByIdWithLock(id);
        item.setQuantity(quantity);
    }

    @Transactional
    public Item findById(Long id) {
        return repository.findByIdWithLock(id);
    }
}

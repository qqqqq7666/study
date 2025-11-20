package com.example.db_lock.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository repository;
    private final ItemRepository itemRepository;

    @Transactional
    public Item save(Item item) {
        return repository.save(item);
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

    @Transactional(timeout = 1, isolation = Isolation.SERIALIZABLE)
    public void updateItemQuantity(Long id1, Long id2) {
        Item item1 = itemRepository.findByIdWithLock(id1);
        item1.setQuantity(item1.getQuantity() + 10);
        itemRepository.save(item1);

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Item item2 = itemRepository.findByIdWithLock(id2);
        item2.setQuantity(item2.getQuantity() + 10);
        itemRepository.save(item2);
    }
}

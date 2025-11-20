package com.example.db_lock;

import com.example.db_lock.item.Item;
import com.example.db_lock.item.ItemRepository;
import com.example.db_lock.item.ItemService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ItemServiceTest {
    private static final Logger log = LoggerFactory.getLogger(ItemServiceTest.class);
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ItemService itemService;

    @Test
    public void testPessimisticLock() throws InterruptedException {
        Item item = Item.builder()
                .name("test item")
                .quantity(1)
                .build();

        itemService.save(item);

        Thread thread1 = new Thread(() -> {
            log.info("Thread 1: 아이템 수량 업데이트 시도");
            itemService.updateQuantity(item.getId(), 20);
            log.info("Thread 1: 아이템 수량 업데이트 완료. 아이템 수량: 20");
        });

        Thread thread2 = new Thread(() -> {
            log.info("Thread 2: 아이템 수량 업데이트 시도");
            itemService.updateQuantity(item.getId(), 30);
            log.info("Thread 2: 아이템 수량 업데이트 완료. 아이템 수량: 30");
        });

        thread2.start();
        thread1.start();

        thread1.join();
        thread2.join();

        Item updatedItem = itemService.findById(item.getId());
        log.info("최종 아이템 수량: {}", updatedItem.getQuantity());
    }
}

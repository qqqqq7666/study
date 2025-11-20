package com.example.db_lock;

import com.example.db_lock.item.Item;
import com.example.db_lock.item.ItemRepository;
import com.example.db_lock.item.ItemService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ItemServiceTest {
    private static final Logger log = LoggerFactory.getLogger(ItemServiceTest.class);
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

    @Test
    void deadlockTest() throws InterruptedException {
        Item item1 = Item.builder()
                .name("test item")
                .quantity(100)
                .build();
        Item savedItem1 = itemService.save(item1);

        Item item2 = Item.builder()
                .name("test item")
                .quantity(200)
                .build();
        Item savedItem2 = itemService.save(item2);

        CountDownLatch latch = new CountDownLatch(1);
        AtomicReference<Exception> exceptionThread = new AtomicReference<>();

        Thread thread1 = new Thread(() -> {
            try {
                log.info("thread1 start");
                latch.await();
                log.info("thread1: attempt item 1 -> item 2 update");
                itemService.updateItemQuantity(savedItem1.getId(), savedItem2.getId());
                log.info("thread1: update complete");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                log.error("unknown error is occurred", e);
                exceptionThread.set(e);
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                log.info("thread2 start");
                latch.await();
                log.info("thread2: attempt item 1 -> item 2 update");
                itemService.updateItemQuantity(savedItem1.getId(), savedItem2.getId());
                log.info("thread2: update complete");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                log.error("unknown error is occurred", e);
                exceptionThread.set(e);
            }
        });

        thread1.start();
        thread2.start();

        latch.countDown();

        thread1.join();
        thread2.join();

        assertThrows(Exception.class, () -> {
            if(exceptionThread.get() != null) {
                throw exceptionThread.get();
            }
        });
    }
}

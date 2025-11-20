package com.example.db_lock;

import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringJUnitConfig
public class MemoryLeakTest {
    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    @Service
    public static class MemoryLeakService {
        public void process(String value) {
            threadLocal.set(value);
        }

        public void clear() {
            threadLocal.remove();
        }
    }

    @Test
    void memoryLeakTest() {
        MemoryLeakService service = new MemoryLeakService();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            int finalInteger = i;
            executorService.submit(() -> {
                service.process("Test " + finalInteger);
//                service.clear();
            });
        }

        executorService.shutdown();
    }
}

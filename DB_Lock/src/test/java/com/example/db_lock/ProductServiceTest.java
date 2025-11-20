package com.example.db_lock;

import com.example.db_lock.product.Product;
import com.example.db_lock.product.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @Test
    void testOptimisticLocking() throws InterruptedException {
        Product product = Product.builder()
                .name("Product 1")
                .price(100.0)
                .build();

        Product savedProduct = productService.save(product);

        Thread thread1 = new Thread(() -> {
            productService.updateProductPrice(savedProduct.getId(), 200.0);
        });

        Thread thread2 = new Thread(() -> {
            productService.updateProductPrice(savedProduct.getId(), 200.0);
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}

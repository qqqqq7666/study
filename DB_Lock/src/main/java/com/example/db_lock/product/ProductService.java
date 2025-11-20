package com.example.db_lock.product;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    public void updateProductPrice(Long id, Double newPrice) {
        try {
            Product product = productRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("product not found"));
            product.setPrice(newPrice);
        } catch (ObjectOptimisticLockingFailureException e) {
            log.error("optimistic lock conflict is occurred");
            throw e;
        }
    }
}

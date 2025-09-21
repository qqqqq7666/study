package com.pm.product_management.infrastructure;

import com.pm.product_management.domain.EntityNotFoundException;
import com.pm.product_management.presentation.ProductDto;
import com.pm.product_management.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Repository
@Profile("test")
@RequiredArgsConstructor
public class ListProductRepository implements ProductRepository{
    // CopyOnWriteArrayList 사용 이유는 웹 애플리케이션이 멀티 스레드라는 특수한 환경이기 때문에 스레드 세이프한 컬랙션을 사용해야 하기 때문
    private final List<Product> productList = new CopyOnWriteArrayList<>();
    // AtomicLong은 CopyOnWriteArrayList와 마찬가지로 스레드 안전성을 가져 Long 타입의 값을 안전하게 다룰수 있게 해준다.
    private AtomicLong sequence = new AtomicLong(1L);

    public Product add(Product product) {
        product.setId(sequence.getAndIncrement());
        productList.add(product);
        return product;
    }

    public List<Product> findAll() {
        return productList;
    }

    public Product findById(Long id) {
        return productList.stream()
                .filter(product -> product.sameId(id))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Product를 찾지 못했습니다."));
    }

    public List<Product> findByNameContaining(String name) {
        return productList.stream()
                .filter(product -> product.containsName(name))
                .toList();
    }

    public Product update(Long id, ProductDto productDto) {
        Product product = findById(id);
        product.update(productDto);
        productList.set(productList.indexOf(product), product);
        return product;
    }

    public void delete(Long id) {
        productList.remove(findById(id));
    }
}

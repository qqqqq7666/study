package com.pm.product_management.infrastructure;

import com.pm.product_management.domain.Product;
import com.pm.product_management.presentation.ProductDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository {
    Product add(Product product);

    List<Product> findAll();

    Product findById(Long id);

    List<Product> findByNameContaining(String name);

    Product update(Long id, ProductDto productDto);

    void delete(Long id);
}

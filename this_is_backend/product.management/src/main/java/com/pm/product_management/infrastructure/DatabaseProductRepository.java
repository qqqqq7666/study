package com.pm.product_management.infrastructure;

import com.pm.product_management.domain.EntityNotFoundException;
import com.pm.product_management.domain.Product;
import com.pm.product_management.presentation.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("prod")
@RequiredArgsConstructor
public class DatabaseProductRepository implements ProductRepository{
    private JdbcTemplate jdbcTemplate;

    public Product add(Product product) {
        return null;
    }

    public List<Product> findAll() {
        return null;
    }

    public Product findById(Long id) {
        return null;
    }

    public List<Product> findByNameContaining(String name) {
        return null;
    }

    public Product update(Long id, ProductDto productDto) {
        return null;
    }

    public void delete(Long id) {
    }
}

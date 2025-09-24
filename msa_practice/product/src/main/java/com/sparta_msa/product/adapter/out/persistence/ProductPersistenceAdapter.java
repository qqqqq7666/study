package com.sparta_msa.product.adapter.out.persistence;

import com.sparta_msa.product.core.domain.Product;
import com.sparta_msa.product.core.port.out.LoadProductPort;
import com.sparta_msa.product.core.port.out.SaveProductPort;
import com.sparta_msa.product.dto.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements SaveProductPort, LoadProductPort {
    private final ProductJpaRepository repository;

    private Product toDomainEntity(JpaProduct jpaProduct) {
        return Product.builder()
                .id(jpaProduct.getId())
                .name(jpaProduct.getName())
                .price(jpaProduct.getPrice())
                .quantity(jpaProduct.getQuantity())
                .status(jpaProduct.getStatus())
                .createdAt(jpaProduct.getCreatedAt())
                .createdBy(jpaProduct.getCreatedBy())
                .updatedAt(jpaProduct.getUpdatedAt())
                .updatedBy(jpaProduct.getUpdatedBy())
                .build();
    }
    @Override
    public Page<Product> getProductList(Pageable pageable) {
        return new PageImpl<>(repository.findAll(pageable)
                .map(this::toDomainEntity)
                .toList());
    }

    @Override
    public Product getProductDetail(Long productId) {
        return toDomainEntity(repository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("invalid productId")));
    }

    @Override
    public Product saveProduct(Product product) {
        return toDomainEntity(repository.save(product.toJpaEntity()));
    }
}

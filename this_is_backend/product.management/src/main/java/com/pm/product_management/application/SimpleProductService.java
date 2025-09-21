package com.pm.product_management.application;

import com.pm.product_management.domain.Product;
import com.pm.product_management.infrastructure.ProductRepository;
import com.pm.product_management.presentation.ProductDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SimpleProductService {
    private final ProductRepository productRepository;
    private final ValidationService validationService;

    public ProductDto add(ProductDto productDto) {
        Product product = productDto.toEntity();
        validationService.checkValid(product);

        Product savedProduct = productRepository.add(product);
        return savedProduct.toDto();
    }

    public List<ProductDto> getProductList() {
        return productRepository.findAll().stream()
                .map(Product::toDto)
                .toList();
    }

    public ProductDto findById(Long id) {
        return productRepository.findById(id).toDto();
    }

    public List<ProductDto> findByNameContaining(String name) {
        return productRepository.findByNameContaining(name)
                .stream()
                .map(Product::toDto)
                .toList();
    }

    public ProductDto updateProduct(Long id, ProductDto productDto) {
        validationService.checkValid(productDto);
        return productRepository.update(id, productDto).toDto();
    }

    public void deleteProduct(Long id) {
        productRepository.delete(id);
    }

}

package com.sparta_msa.product.core.application;

import com.sparta_msa.product.core.domain.Product;
import com.sparta_msa.product.core.domain.ProductStatus;
import com.sparta_msa.product.core.port.in.CreateProductUseCase;
import com.sparta_msa.product.core.port.in.GetProductUseCase;
import com.sparta_msa.product.core.port.in.UpdateProductUseCase;
import com.sparta_msa.product.core.port.out.LoadProductPort;
import com.sparta_msa.product.core.port.out.SaveProductPort;
import com.sparta_msa.product.dto.ProductRequestDto;
import com.sparta_msa.product.dto.ProductResponseDto;
import com.sparta_msa.product.dto.ProductUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService implements CreateProductUseCase, GetProductUseCase, UpdateProductUseCase {
    private final SaveProductPort savePort;
    private final LoadProductPort loadPort;

    public Product toDomainEntity(ProductRequestDto requestDto) {
        return Product.builder()
                .status(ProductStatus.판매_중)
                .name(requestDto.name())
                .price(requestDto.price())
                .quantity(requestDto.quantity())
                .build();
    }

    @Override
    public ProductResponseDto createProduct(ProductRequestDto requestDto) {
        return savePort.saveProduct(toDomainEntity(requestDto)).toResponseDto();
    }

    @Override
    public ResponseEntity<Page<ProductResponseDto>> getProductList(int page) {
        Pageable pageable = Pageable.ofSize(10)
                .withPage(10);
        return ResponseEntity.ok(loadPort.getProductList(pageable)
                .map(Product::toResponseDto));
    }

    @Override
    public ResponseEntity<ProductResponseDto> getProductDetail(Long productId) {
        return ResponseEntity.ok(loadPort.getProductDetail(productId).toResponseDto());
    }

    @Override
    public ProductResponseDto updateProduct(Long productId, ProductUpdateDto updateDto) {
        return null;
    }

    @Override
    public ProductResponseDto deleteProduct(Long productId) {
        return null;
    }
}

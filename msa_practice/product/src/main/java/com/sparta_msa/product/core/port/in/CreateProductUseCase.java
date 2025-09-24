package com.sparta_msa.product.core.port.in;

import com.sparta_msa.product.dto.ProductRequestDto;
import com.sparta_msa.product.dto.ProductResponseDto;
import org.springframework.http.ResponseEntity;

public interface CreateProductUseCase {
    ResponseEntity<ProductResponseDto> createProduct(ProductRequestDto requestDto);
}

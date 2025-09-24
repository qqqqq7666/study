package com.sparta_msa.product.core.port.in;

import com.sparta_msa.product.dto.ProductResponseDto;
import com.sparta_msa.product.dto.ProductUpdateDto;
import org.springframework.http.ResponseEntity;

public interface UpdateProductUseCase {
    ResponseEntity<ProductResponseDto> updateProduct(Long productId, ProductUpdateDto updateDto);
    ResponseEntity<ProductResponseDto> deleteProduct(Long productId);
    ResponseEntity<ProductResponseDto> reduceQuantity(Long productId, Integer quantity);
}

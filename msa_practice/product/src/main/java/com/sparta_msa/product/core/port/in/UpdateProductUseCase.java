package com.sparta_msa.product.core.port.in;

import com.sparta_msa.product.dto.ProductResponseDto;
import com.sparta_msa.product.dto.ProductUpdateDto;

public interface UpdateProductUseCase {
    ProductResponseDto updateProduct(Long productId, ProductUpdateDto updateDto);
    ProductResponseDto deleteProduct(Long productId);
}

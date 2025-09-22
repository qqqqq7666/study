package com.sparta_msa.product.core.port.in;

import com.sparta_msa.product.dto.ProductRequestDto;
import com.sparta_msa.product.dto.ProductResponseDto;

public interface CreateProductUseCase {
    ProductResponseDto createProduct(ProductRequestDto requestDto);
}

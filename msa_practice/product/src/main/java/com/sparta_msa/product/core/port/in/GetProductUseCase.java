package com.sparta_msa.product.core.port.in;

import com.sparta_msa.product.dto.ProductResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GetProductUseCase {
    Page<ProductResponseDto> getProductList(Pageable pageable);
    ProductResponseDto getProductDetail(Long productId);
}

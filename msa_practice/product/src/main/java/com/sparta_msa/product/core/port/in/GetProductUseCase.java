package com.sparta_msa.product.core.port.in;

import com.sparta_msa.product.dto.ProductResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface GetProductUseCase {
    ResponseEntity<Page<ProductResponseDto>> getProductList(int page);
    ResponseEntity<ProductResponseDto> getProductDetail(Long productId);
}

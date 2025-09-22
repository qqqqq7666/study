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
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService implements CreateProductUseCase, GetProductUseCase, UpdateProductUseCase {
    private final SaveProductPort savePort;
    private final LoadProductPort loadPort;

    public Product toDomainEntity(ProductRequestDto requestDto) {
        return Product.builder()
                .status(ProductStatus.판매_중)
                .price()
    }

    @Override
    public ProductResponseDto createProduct(ProductRequestDto requestDto) {
        return savePort.saveProduct();
    }

    @Override
    public Page<ProductResponseDto> getProductList(Pageable pageable) {
        return null;
    }

    @Override
    public ProductResponseDto getProductDetail(Long productId) {
        return null;
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

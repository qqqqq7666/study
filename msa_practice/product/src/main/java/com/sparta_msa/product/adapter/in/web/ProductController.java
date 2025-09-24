package com.sparta_msa.product.adapter.in.web;

import com.sparta_msa.product.core.port.in.CreateProductUseCase;
import com.sparta_msa.product.core.port.in.GetProductUseCase;
import com.sparta_msa.product.core.port.in.UpdateProductUseCase;
import com.sparta_msa.product.dto.ProductRequestDto;
import com.sparta_msa.product.dto.ProductResponseDto;
import com.sparta_msa.product.dto.ProductUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final CreateProductUseCase createProductUseCase;
    private final GetProductUseCase getProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;

    @PostMapping
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductRequestDto requestDto) {
        return createProductUseCase.createProduct(requestDto);
    }

    @GetMapping
    public ResponseEntity<Page<ProductResponseDto>> getProductList(@RequestParam int page) {
        return getProductUseCase.getProductList(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProductDetail(@PathVariable long id) {
        return getProductUseCase.getProductDetail(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProductResponseDto> updateProduct(@PathVariable long id, @RequestBody ProductUpdateDto updateDto) {
        return updateProductUseCase.updateProduct(id, updateDto);
    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity<ProductResponseDto> deleteProduct(@PathVariable long id) {
        return updateProductUseCase.deleteProduct(id);
    }

    @PatchMapping("/{id}/quantity")
    public ResponseEntity<ProductResponseDto> reduceQuantity(@PathVariable long id, @RequestParam int quantity) {
        return updateProductUseCase.reduceQuantity(id, quantity);
    }
}

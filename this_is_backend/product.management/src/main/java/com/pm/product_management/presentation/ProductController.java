package com.pm.product_management.presentation;

import com.pm.product_management.application.SimpleProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final SimpleProductService simpProductService;

    @PostMapping
    public ProductDto createProduct(@Valid @RequestBody ProductDto productDto) {
        return simpProductService.add(productDto);
    }

    @GetMapping
    public List<ProductDto> findProducts(@RequestParam(required = false) String name) {
        if(name == null || name.isEmpty())
            return simpProductService.getProductList();

        return simpProductService.findByNameContaining(name);
    }

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) {
        return simpProductService.findById(id);
    }

    @PutMapping("/{id}")
    public ProductDto updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        return simpProductService.updateProduct(id, productDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        simpProductService.deleteProduct(id);
    }
}

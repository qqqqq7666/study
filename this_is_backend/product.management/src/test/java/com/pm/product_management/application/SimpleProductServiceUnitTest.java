package com.pm.product_management.application;

import com.pm.product_management.domain.Product;
import com.pm.product_management.infrastructure.ProductRepository;
import com.pm.product_management.presentation.ProductDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SimpleProductServiceUnitTest {
    @Mock
    private ProductRepository productRepository;
    @Mock
    private ValidationService validationService;
    @InjectMocks
    private SimpleProductService simpleProductService;

    @Test
    @DisplayName("상품 추가 후에는 추가된 상품이 반환되어야 한다.")
    void productAddTest() {
        ProductDto productDto = ProductDto.builder()
                .name("연필")
                .price(300)
                .amount(20)
                .build();

        Long PRODUCT_ID = 1L;

        Product product = productDto.toEntity();
        product.setId(PRODUCT_ID);
        when(productRepository.add(any()))
                .thenReturn(product);

        ProductDto savedProductDto = simpleProductService.add(productDto);

        assertEquals(savedProductDto.id(), PRODUCT_ID);
    }
}

package com.pm.product_management.application;

import com.pm.product_management.domain.EntityNotFoundException;
import com.pm.product_management.presentation.ProductDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@ActiveProfiles("test")
@RequiredArgsConstructor
public class SimpleProductServiceTest {
    @Autowired
    SimpleProductService simpleProductService;

    @Test
    @Transactional
    @DisplayName("상품 추가 후 id로 조회하면 해당 상품이 조회되어야 한다.")
    void productAddAndFIndByIdTest() {
        ProductDto productDto = ProductDto.builder()
                .name("연필")
                .price(300)
                .amount(20)
                .build();

        ProductDto savedProductDto = simpleProductService.add(productDto);
        Long savedProductId = savedProductDto.id();

        ProductDto foundProductDto = simpleProductService.findById(savedProductId);

        assertTrue(foundProductDto.price() == savedProductDto.price());

//        assertEquals(savedProductDto.id(), 3);
//        assertEquals(savedProductDto.name(), foundProductDto.name());
//        assertEquals(savedProductDto.price(), foundProductDto.price());
//        assertEquals(savedProductDto.amount(), foundProductDto.amount());

    }

    @Test
    void test() {
        String str1 = new String("123");
        String str2 = new String("123");
        String str3 = str1;

        assertEquals(str1, str2);   // pass
        assertSame(str1, str2);     // fail
        assertSame(str1, str3);     // pass
        str1 = new String("123");
        assertSame(str1, str3);     // fail
    }

    @Test
    @DisplayName("존재하지 않는 상품 id로 조회하면 EntityNotFoundException 발생")
    void findProductNotExist() {
        Long notExistId = -1L;

        assertThrows(EntityNotFoundException.class, () ->
            simpleProductService.findById(notExistId)
        );
    }
}

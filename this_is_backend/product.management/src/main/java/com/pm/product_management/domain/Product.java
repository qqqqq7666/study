package com.pm.product_management.domain;

import com.pm.product_management.presentation.ProductDto;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.ToString;

@ToString
@Builder
public class Product {
    private Long id;
    @Size(min = 1, max = 100)
    private String name;
    @Max(1_000_000)
    @Min(0)
    private Integer price;
    @Max(9_999)
    @Min(0)
    private Integer amount;

    public void setId(Long id) {
        this.id = id;
    }

    public ProductDto toDto(){
        return ProductDto.builder()
                .id(id)
                .name(name)
                .price(price)
                .amount(amount)
                .build();
    }

    public Boolean sameId(Long id){
        return this.id.equals(id);
    }

    public Boolean containsName(String name) {
        return this.name.contains(name);
    }

    public void update(ProductDto productDto) {
        name = productDto.name();
        price = productDto.price();
        amount = productDto.amount();
    }
}
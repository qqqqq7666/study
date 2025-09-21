package com.spring_cloud.eureka.client.product;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Product {
    private String id;
    private String title;
}

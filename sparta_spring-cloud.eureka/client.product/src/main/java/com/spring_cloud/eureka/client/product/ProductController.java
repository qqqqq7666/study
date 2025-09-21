package com.spring_cloud.eureka.client.product;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @Value("${server.port}")
    private String serverPort;

    @Value("${message}")
    private String message;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductInfo(@PathVariable("id") String id) {
        return ResponseEntity.ok(productService.getProductDetails(id));
    }

    @GetMapping
    public String getProduct() {
        return "Product info!!!!! From port : " + serverPort + " and message : " + message;
    }

}

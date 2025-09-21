package com.spring_cloud.eureka.client.product;

import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final CircuitBreakerRegistry circuitBreakerRegistry;

    @PostConstruct
    public void registerEventListener() {
        circuitBreakerRegistry.circuitBreaker("productService").getEventPublisher()
                .onStateTransition(event -> log.info("#######CircuitBreaker State Transition: {}", event)) // 상태 전환 이벤트 리스너
                .onFailureRateExceeded(event -> log.info("#######CircuitBreaker Failure Rate Exceeded: {}", event)) // 실패율 초과 이벤트 리스너
                .onCallNotPermitted(event -> log.info("#######CircuitBreaker Call Not Permitted: {}", event)) // 호출 차단 이벤트 리스너
                .onError(event -> log.info("#######CircuitBreaker Error: {}", event)); // 오류 발생 이벤트 리스너
    }

    @CircuitBreaker(name = "productService", fallbackMethod = "fallbackGetProductDetails")
    public Product getProductDetails(String productId) {
        log.info("###Fetching product details for productId: {}", productId);
        if ("111".equals(productId)) {
            log.warn("###Received empty body for productId: {}", productId);
            throw new RuntimeException("Empty response body");
        }
        return Product.builder()
                .id(productId)
                .title("Sample Product")
                .build();
    }

    public Product fallbackGetProductDetails(String productId, Throwable t) {
        log.error("####Fallback triggered for productId: {} due to: {}", productId, t.getMessage());
        // 에러 복구 코드 외에도 관리자에게 에러가 발생했음을 알리는 코드가 들어가야 한다. (Slack or Smtp 등)
        return Product.builder()
                .id(productId)
                .title("Fallback Product")
                .build();
    }
}

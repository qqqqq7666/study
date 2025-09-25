package com.sparta_msa.product.core.application;

import com.sparta_msa.product.core.domain.Product;
import com.sparta_msa.product.core.port.out.LoadProductPort;
import com.sparta_msa.product.core.port.out.SaveProductPort;
import com.sparta_msa.product.dto.OrderItemRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderEventListener {
    private final SaveProductPort saveProductPort;
    private final LoadProductPort loadProductPort;

    @Transactional
    @RabbitListener(queues = "stock.queue")
    public void handleOrderEvent(List<OrderItemRequestDto> requestDtoList) {
        log.info("#### Product receive message: {}", requestDtoList);
        requestDtoList.forEach(item -> {
            Product product = loadProductPort.getProductDetail(item.productId());
            product.reduceQuantity(item.quantity());

            saveProductPort.saveProduct(product);
        });
    }
}

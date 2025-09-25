package com.sparta_msa.order.adapter.out.persistence;

import com.sparta_msa.order.core.domain.Order;
import com.sparta_msa.order.core.domain.OrderItem;
import com.sparta_msa.order.core.port.out.LoadOrderPort;
import com.sparta_msa.order.core.port.out.SaveOrderPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OrderPersistenceAdapter implements SaveOrderPort, LoadOrderPort {
    private final OrderJpaRepository repository;
    private final OrderItemRepository orderItemRepository;

    @Override
    public Page<Order> loadOrderList(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<Order> loadOrderById(Long orderId) {
        return repository.findById(orderId);
    }

    @Override
    public Order saveOrder(Order order) {
        return repository.save(order);
    }

    @Override
    public OrderItem saveOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }
}

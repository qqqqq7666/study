package com.sparta_msa.order.core.port.out;

import com.sparta_msa.order.core.domain.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface LoadOrderPort {
    Page<Order> loadOrderList(Pageable pageable);
    Optional<Order> loadOrderById(Long orderId);
}

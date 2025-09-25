package com.sparta_msa.order.adapter.out.persistence;

import com.sparta_msa.order.core.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}

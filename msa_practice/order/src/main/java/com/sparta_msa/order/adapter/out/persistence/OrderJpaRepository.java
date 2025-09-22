package com.sparta_msa.order.adapter.out.persistence;

import com.sparta_msa.order.core.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepository extends JpaRepository<Order, Long> {
}

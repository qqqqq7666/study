package com.sparta_msa.order.core.port.out;

import com.sparta_msa.order.core.domain.Order;
import com.sparta_msa.order.core.domain.OrderItem;

public interface SaveOrderPort {
    Order saveOrder(Order order);
    OrderItem saveOrderItem(OrderItem orderItem);
}

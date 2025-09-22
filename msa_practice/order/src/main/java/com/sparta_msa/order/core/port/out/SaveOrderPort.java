package com.sparta_msa.order.core.port.out;

import com.sparta_msa.order.core.domain.Order;

public interface SaveOrderPort {
    Order saveOrder(Order order);
}

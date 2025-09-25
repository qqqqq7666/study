package com.sparta_msa.order.core.domain;

import com.sparta_msa.order.dto.OrderResponseDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private OrderStatus status;
    private String memo;

    @CreatedDate
    private LocalDateTime createdAt;
    @CreatedBy
    private String createdBy;
    @LastModifiedDate
    private LocalDateTime updatedAt;
    @LastModifiedBy
    private String updatedBy;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderItem> orderItemList = new ArrayList<>();

    @Builder
    public Order(Long id,
                 OrderStatus status,
                 String memo,
                 List<OrderItem> orderItemList,
                 LocalDateTime createdAt,
                 String createdBy,
                 LocalDateTime updatedAt,
                 String updatedBy) {
        this.id = id;
        this.status = status;
        this.memo = memo;
        this.orderItemList = orderItemList;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
    }

    public OrderResponseDto toResponseDto() {
        return OrderResponseDto.builder()
                .id(id)
                .orderStatus(status)
                .memo(memo)
                .build();
    }

    public void updateStatus(OrderStatus status) {
        this.status = status;
    }

    public void deleteOrder() {
        status = OrderStatus.삭제;
    }

    public void placeOrderItem(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}

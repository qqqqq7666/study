package com.example.redis.repository;

import com.example.redis.entity.ItemOrder;
import org.springframework.data.repository.CrudRepository;

public interface ItemOrderRepository extends CrudRepository<ItemOrder, String> {
}

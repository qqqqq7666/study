package com.example.redis.repository;

import com.example.redis.entity.ItemJpaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemJpaRepository extends JpaRepository<ItemJpaEntity, Long> {
    Page<ItemJpaEntity> findAllByNameContains(String name, Pageable pageable);
}

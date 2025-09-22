package com.sparta_msa.product.adapter.out.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<JpaProduct, Long> {
    @Override
    Page<JpaProduct> findAll(Pageable pageable);
}

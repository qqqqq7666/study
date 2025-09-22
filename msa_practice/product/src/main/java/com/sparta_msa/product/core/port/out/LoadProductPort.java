package com.sparta_msa.product.core.port.out;

import com.sparta_msa.product.core.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LoadProductPort {
    Page<Product> getProductList(Pageable pageable);
    Product getProductDetail(Long productId);
}

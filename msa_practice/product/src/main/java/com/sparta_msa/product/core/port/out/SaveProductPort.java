package com.sparta_msa.product.core.port.out;

import com.sparta_msa.product.adapter.out.persistence.JpaProduct;
import com.sparta_msa.product.core.domain.Product;

public interface SaveProductPort {
    Product saveProduct(Product product);
}

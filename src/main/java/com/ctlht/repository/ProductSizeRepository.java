package com.ctlht.repository;

import com.ctlht.entity.ProductSizeEntity;
import com.ctlht.entity.SizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSizeRepository extends JpaRepository<ProductSizeEntity, Long> {
    ProductSizeEntity findByProductIdAndSizeCode(Long productId, String size);
}

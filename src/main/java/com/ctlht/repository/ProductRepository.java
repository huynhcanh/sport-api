package com.ctlht.repository;

import com.ctlht.entity.ProductEntity;
import com.ctlht.repository.custom.ProductRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>,
        ProductRepositoryCustom {
}

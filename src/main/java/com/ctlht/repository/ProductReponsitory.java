package com.ctlht.repository;

import com.ctlht.entity.ProductEntity;
import com.ctlht.repository.custom.ProductReponsitoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductReponsitory   extends JpaRepository<ProductEntity, Long>,
        ProductReponsitoryCustom {
}

package com.ctlht.repository;

import com.ctlht.entity.ProductSizeEntity;
import com.ctlht.entity.SizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSizeReponsitory extends JpaRepository<ProductSizeEntity, Long> {
}

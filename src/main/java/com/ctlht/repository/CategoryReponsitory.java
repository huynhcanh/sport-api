package com.ctlht.repository;

import com.ctlht.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryReponsitory extends JpaRepository<CategoryEntity, Long> {
    CategoryEntity findByCode(String code);
}

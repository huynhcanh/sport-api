package com.ctlht.repository;

import com.ctlht.entity.CategoryEntity;
import com.ctlht.entity.SizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SizeRepository extends JpaRepository<SizeEntity, Long> {
    SizeEntity findByCode(String code);
}

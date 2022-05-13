package com.ctlht.repository;

import com.ctlht.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Long>{
    RoleEntity findByCode(String code);
}


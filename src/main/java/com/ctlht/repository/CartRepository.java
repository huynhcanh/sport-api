package com.ctlht.repository;

import com.ctlht.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<CartEntity, Long> {
    List<CartEntity> findAllByUserId(Long userId);
}

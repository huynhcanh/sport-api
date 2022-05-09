package com.ctlht.repository;

import com.ctlht.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, Long> {

}

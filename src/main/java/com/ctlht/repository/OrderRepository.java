package com.ctlht.repository;

import com.ctlht.entity.OrderEntity;
import com.ctlht.repository.custom.OrderRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long>, OrderRepositoryCustom {

}

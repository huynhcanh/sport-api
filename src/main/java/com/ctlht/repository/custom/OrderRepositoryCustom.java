package com.ctlht.repository.custom;

import com.ctlht.entity.OrderEntity;
import com.ctlht.entity.ProductEntity;

import java.util.List;
import java.util.Map;

public interface OrderRepositoryCustom {
    List<OrderEntity> getOrdersByFields(Map<String, String> params);
}

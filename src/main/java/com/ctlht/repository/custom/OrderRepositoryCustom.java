package com.ctlht.repository.custom;

import com.ctlht.entity.OrderEntity;

import java.util.List;
import java.util.Map;

public interface OrderRepositoryCustom {
    List<OrderEntity> getOrdersByFields(Map<String, String> params);

    List<OrderEntity> getOrdersByCurrentMonth(String month);

    List<OrderEntity> countOrdersByDay(String day);
}

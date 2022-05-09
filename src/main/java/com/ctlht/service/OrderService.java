package com.ctlht.service;

import com.ctlht.entity.OrderEntity;
import com.ctlht.model.response.CategoryResponse;
import com.ctlht.model.response.OrderResponse;

import java.util.List;
import java.util.Map;

public interface OrderService {
    List<OrderResponse> getOrdersByFields(Map<String, String> params);
}

package com.ctlht.service;

import com.ctlht.model.response.OrderResponse;
import com.ctlht.model.response.TurnoverResponse;

import java.util.List;
import java.util.Map;

public interface OrderService {
    List<OrderResponse> getOrdersByFields(Map<String, String> params);

    OrderResponse insertOrderToAllCartByUser(Map<String, Object> params);

    TurnoverResponse getOrdersTurnOverByCurrentMonth(String month);

    int countOrdersByDay(String day);
}
